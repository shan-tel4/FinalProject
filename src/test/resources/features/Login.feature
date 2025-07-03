@loginLogout @smoke @regression


Feature: Login Functionality

  Scenario Outline: Login attempts with different credential combinations
    Given the user is on the Swag Lab page
    When the user enters username "<username>" and password "<password>"
    And the user clicks the login button
    Then <loginOutcome>

    Examples:
      | username                 | password       | loginOutcome                               |
      | standard_user           | secret_sauce   | the user is logged in successfully         |
      | invalid_user            | wrong_password | an error message is displayed on the login page |
      | invalid_user            | secret_sauce   | an error message is displayed on the login page |
      | error_user              | secret_sauce   | an error message is displayed on the login page |
      | performance_glitch_user | secret_sauce   | an error message is displayed on the login page |
      | standard_user           | wrong_password | an error message is displayed on the login page |
      | problem_user            | secret_sauce   | an error message is displayed on the login page |
      | locked_out_user         | secret_sauce   | an error message is displayed on the login page |







