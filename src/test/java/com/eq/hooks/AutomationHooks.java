package com.eq.hooks;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class AutomationHooks {

	public WebDriver driver;
	public WebDriverWait wait;
	private Properties config;

	@Before
	public void setupScenario(Scenario scenario) throws FileNotFoundException, IOException {
		// Load configuration properties
		loadConfiguration();

		// Initialize WebDriver based on config
		String browser = config.getProperty("browser", "chrome").toLowerCase();
		initializeDriver(browser);

		// Set up WebDriverWait
		int timeout = Integer.parseInt(config.getProperty("timeout", "10"));
		wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));

		// Configure browser settings
		configureBrowser();
	}

	@After
	public void teardownScenario(Scenario scenario) {
		// Take screenshot if scenario failed
		if (scenario.isFailed() && driver != null) {
			takeScreenshot(scenario);
		}

		if (driver != null) {
			driver.quit();
		}
	}

	private void loadConfiguration() throws FileNotFoundException, IOException {
		config = new Properties();
		try (FileInputStream fis = new FileInputStream("src/test/resources/config.properties")) {
			config.load(fis);
		}
	}

	private void initializeDriver(String browser) {
		if (browser.equalsIgnoreCase("ff")) {
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.addArguments("--start-maximized"); // optional: maximize window

			// Headless mode if enabled in config
			if (Boolean.parseBoolean(config.getProperty("headless", "false"))) {
				firefoxOptions.addArguments("--headless");
			}
			driver = new FirefoxDriver(firefoxOptions);

		} else if (browser.equalsIgnoreCase("edge")) {
			EdgeOptions edgeOptions = new EdgeOptions();
			edgeOptions.addArguments("--start-maximized");
			edgeOptions.addArguments("--disable-notifications");

			// Headless mode if enabled in config
			if (Boolean.parseBoolean(config.getProperty("headless", "false"))) {
				edgeOptions.addArguments("--headless=new"); // Use --headless=new for latest Edge
			}
			driver = new EdgeDriver(edgeOptions);
		} else {
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--start-maximized");
			chromeOptions.addArguments("--disable-notifications");
			if (Boolean.parseBoolean(config.getProperty("headless", "false"))) {
				chromeOptions.addArguments("--headless");
			}
			driver = new ChromeDriver(chromeOptions);
		}
	}

	private void configureBrowser() {
		driver.manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(Integer.parseInt(config.getProperty("implicitWait", "5"))));
		driver.manage().window().maximize();

		String baseUrl = config.getProperty("baseUrl");
		if (baseUrl != null && !baseUrl.isEmpty()) {
			driver.get(baseUrl);
		}
	}

	private void takeScreenshot(Scenario scenario) {
		byte[] screenshot = ((org.openqa.selenium.TakesScreenshot) driver)
				.getScreenshotAs(org.openqa.selenium.OutputType.BYTES);
		scenario.attach(screenshot, "image/png", "Screenshot");

	}
}