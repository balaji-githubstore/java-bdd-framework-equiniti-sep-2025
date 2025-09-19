package com.eq.steps;

import java.util.List;
import java.util.Map;

import com.eq.pages.HomePage;
import com.eq.pages.SignUpPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;

public class SignUpSteps {
	
	private HomePage home;
	private SignUpPage signUp;
	public SignUpSteps(HomePage home,SignUpPage signUp)
	{
		this.home=home;
		this.signUp=signUp;
	}
	
	@When("User click on Sign up")
	public void user_click_on_sign_up() {
	    home.clickOnSignUp();
	}
	@When("User enter fill new registration form")
	public void user_enter_fill_new_registration_form(DataTable dataTable) {
		
		System.out.println(dataTable);	
		List<Map<String, String>> lists= dataTable.asMaps();
		System.out.println(lists);
		
		System.out.println(lists.get(0).get("email_address"));
		System.out.println(lists.get(0).get("username"));
		System.out.println(lists.get(0).get("password"));
		System.out.println(lists.get(0).get("country"));
		System.out.println(lists.get(0).get("email_preference_check"));
		
		signUp.addNewRegistrationDetail(lists.get(0).get("email_address"), 
				lists.get(0).get("username"), lists.get(0).get("password"), 
				lists.get(0).get("country"), lists.get(0).get("email_preference_check"));
		
	}
	
	@When("User click on create account")
	public void user_click_on_create_account() {
	  
	}

}
