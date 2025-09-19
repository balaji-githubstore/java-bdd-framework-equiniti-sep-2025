package com.eq.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	@Given("User have browser with github home page")
	public void user_have_browser_with_github_home_page() {
		
	}

	@When("User enter username as {string}")
	public void user_enter_username_as(String username) {
		System.out.println("when" + username);
	}

	@When("User enter password as {string}")
	public void user_enter_password_as(String password) {
		System.out.println("when" + password);
	}

	@When("User click on Sign in")
	public void user_click_on_sign_in() {
		System.out.println("when login");
	}

	@Then("User should gets access to dashboard with header as {string}")
	public void user_should_gets_access_to_dashboard_with_header_as(String expectedValue) {
		System.out.println("then" + expectedValue);
	}
	
	@Then("User should not get access with error as {string}")
	public void user_should_not_get_access_with_error_as(String expectedError) {
	   System.out.println("then"+expectedError);
	}

}
