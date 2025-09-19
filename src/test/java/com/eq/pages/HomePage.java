package com.eq.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.eq.hooks.AutomationHooks;

public class HomePage {

	private By signInLocator = By.xpath("(//a[normalize-space()='Sign in'])[2]");
	private By signUpLocator = By.xpath("//a[normalize-space()='Sign up']");

	private final WebDriver driver;

	public HomePage(AutomationHooks hooks) {
		this.driver = hooks.driver;
	}

	public void navigateToUrl() {
		driver.get("https://github.com/");
	}

	public void clickOnSignIn() {
		driver.findElement(signInLocator).click();
	}

	public void clickOnSignUp() {
		driver.findElement(signUpLocator).click();
	}

}
