@login	@regression
Feature: Login
  In order to manage remote repositories
  As a user
  I want to login into the github

  Background:
    Given User have browser with github home page

	@smoke @valid	@sanity
  Scenario: Valid Credential
    When User enter username as "balaji-githubstore"
    And User enter password as "welcome@123"
    And User click on Sign in
    Then User should gets access to dashboard with header as "Top repositories"
    
	@invalid  @sanity 
  Scenario Outline: Invalid credential
    When User enter username as "<username>"
    And User enter password as "<password>"
    And User click on Sign in
    Then User should not get access with error as "<expected_error>"
    Examples:
      | username | password | expected_error                  |
      | john     | john123  | Incorrect username or password. |
      | peter    | peter123 | Incorrect username or password. |

  