package com.eq.steps;

import org.testng.Assert;

import com.eq.pages.HomePage;
import com.eq.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	
	private final HomePage home;
	private final LoginPage login;
	
	public LoginSteps(HomePage home,LoginPage login)
	{
		this.home=home;
		this.login=login;
	}

	@Given("User have browser with github home page")
	public void user_have_browser_with_github_home_page() {
		home.navigateToUrl();
	}
	
	@When("User click on sign in from homepage")
	public void user_click_on_sign_in_from_homepage() {
	    home.clickOnSignIn();
	}

	@When("User enter username as {string}")
	public void user_enter_username_as(String username) {
		login.enterUsername(username);
	}

	@When("User enter password as {string}")
	public void user_enter_password_as(String password) {
		login.enterPassword(password);
	}

	@When("User click on Sign in")
	public void user_click_on_sign_in() {
		login.clickOnSignIn();
	}

	@Then("User should gets access to dashboard with header as {string}")
	public void user_should_gets_access_to_dashboard_with_header_as(String expectedValue) {
		System.out.println("then" + expectedValue);
	}
	
	@Then("User should not get access with error as {string}")
	public void user_should_not_get_access_with_error_as(String expectedError) {
	   String actualError= login.getInvalidErrorMessage();
	   Assert.assertEquals(actualError, expectedError);
	   
//	   Assert.assertTrue(actualError.contains(expectedError));  //expects true
	}

}
