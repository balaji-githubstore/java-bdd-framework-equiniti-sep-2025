package com.eq.pages;

import org.openqa.selenium.WebDriver;

import com.eq.hooks.AutomationHooks;

public class SignUpPage {
	private final WebDriver driver;

	public SignUpPage(AutomationHooks hooks) {
		this.driver = hooks.driver;
	}
	
	public void addNewRegistrationDetail(String email,String username,String password,String country, String pref)
	{
		
	}
}
