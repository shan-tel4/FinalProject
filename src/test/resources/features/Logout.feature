Feature: Logout Functionality

  Background:
    Given the user has successfully logged in
    And is on the inventory page


  Scenario: User successfully logs out
    Given the user is logged into the Swag Lab page
    When the user clicks the burger menu icon
    And the user clicks the log out button
    Then the user should successfully log out
