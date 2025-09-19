package com.eq.hooks;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class AutomationHooks {

	public WebDriver driver;
	
	@Before
	public void startScenario()
	{
		//System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@After
	public void endScenario()
	{
		if(driver !=null)
		{
			driver.quit();
		}
	}
}



