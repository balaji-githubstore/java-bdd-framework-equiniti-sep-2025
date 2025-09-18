@register
Feature: SignUp
  In order to manage remote repositories
  As a user
  I want to create an account in the github


  Scenario Outline: Valid New Registration
    Given User have browser with github home page
    When User click on Sign up
    And User enter fill new registration form
      | email_address | username | password | country   | email_preference_check |
      | <email>       | <user>   | <pass>   | <country> | <email_pref>           |
    And User click on create account
    Then User should gets access to dashboard with header as "<expected_header>"
    Examples:
      | email           | user  | pass     | country  | email_pref | expected_header  |
      | john@gmail.com  | john  | john123  | Malaysia | yes        | Top repositories |
      | peter@gmail.com | peter | peter123 | India    | no         | Top repositories |
    
    
    