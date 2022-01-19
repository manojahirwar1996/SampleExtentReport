
Feature: Signup
 @accounts
  Scenario: Signup the user
   Given User is on home page
   When User clicks signup
   Then Sign pop should appear
    And Enter Username "aasdt"
    And Enter Password "pasword"
    Then User should be signed up
