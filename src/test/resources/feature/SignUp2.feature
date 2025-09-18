#@register
#Feature: SignUp
#  In order to manage remote repositories
#  As a user
#  I want to create an account in the github
#
#
#  Scenario: Valid New Registration
#    Given User have browser with github home page
#    When User click on Sign up
#    And User enter fill new registration form
#      | email_address  | username | password    | country  | email_preference_check |
#      | john@gmail.com | john_123 | welcome@123 | Malaysia | yes                    |
#    And User click on create account
#    Then User should gets access to dashboard with header as "Top repositories"
#
#
#  Scenario: Valid New Registration2
#    Given User have browser with github home page
#    When User click on Sign up
#    And User enter fill new registration form
#      | email_address   | username  | password    | country  | email_preference_check |
#      | peter@gmail.com | peter_123 | welcome@123 | Malaysia | yes                    |
#    And User click on create account
#    Then User should gets access to dashboard with header as "Top repositories"