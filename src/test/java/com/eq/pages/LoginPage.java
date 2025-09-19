package com.eq.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eq.hooks.AutomationHooks;

public class LoginPage {

	private By usernameLocator = By.id("login_field");
	private By passwordLocator = By.id("password");
	private By signInLocator = By.name("commit");
	private By errorLocator = By.xpath("//div[contains(normalize-space(),'Incorrect user') and @role='alert']");

	private final WebDriver driver;

	public LoginPage(AutomationHooks hooks) {
		this.driver = hooks.driver;
	}

	public void enterUsername(String username) {
		driver.findElement(usernameLocator).sendKeys(username);
	}

	public void enterPassword(String password) {
		driver.findElement(passwordLocator).sendKeys(password);
	}

	public void clickOnSignIn() {
		driver.findElement(signInLocator).click();
	}

	public String getInvalidErrorMessage() {
		return driver.findElement(errorLocator).getText();
	}

}
