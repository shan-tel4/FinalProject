Feature: Checkout functionality

  Background:
    Given the user has successfully logged in
    And is on the inventory page

  Scenario: Validate Successful Purchase Completion and Display of Confirmation Message For Standard User
    When the user clicks the "Add to cart" button on a product
    And adds an additional product
    And the product is added to the cart
    And the user clicks on the cart icon
    And the user is on the "Your Cart" page
    And a list of products is displayed
    And the user clicks “Checkout” button
    And the user is on the "Your Information" form
    And the user inputs valid credentials
    And the user clicks the "Continue" button
    And the user is on the "Checkout Overview" page
    And the user clicks the "Finish" button
    And the user is on the "Order Confirmation" page
    And the user clicks back home
    Then the user is redirected to the inventory page

  Scenario: Validate checkout summary details for standard user
    When the user clicks the "Add to cart" button on a product
    And the user clicks on the cart icon
    And the user is on the "Your Cart" page
    And a list of products is displayed
    And the user clicks “Checkout” button
    And the user is on the "Your Information" form
    And the user inputs valid credentials
    And the user clicks the "Continue" button
    And the user is on the "Checkout Overview" page
    And a list of products is displayed
    Then a summary of information is displayed

    # Not finished
  Scenario: Validate Empty Postcode Field Handling For Logged-in User
    When the user clicks the "Add to cart" button on a product
    And the user clicks on the cart icon
    And the user is on the "Your Cart" page
    And a list of products is displayed
    And the user clicks “Checkout” button
    And the user is on the "Your Information" form
    And the user inputs valid first name and last name
    And the user inputs invalid post code
    And the user clicks the "Continue" button
    Then the error message and red x icon is displayed for invalid field

  Scenario: Successful checkout initiation for Standard User
    When the user clicks the "Add to cart" button on a product
    And the product is added to the cart
    And the cart icon increases to 1
    And the user clicks on the cart icon
    And the user is on the "Your Cart" page
    And the user clicks “Checkout” button
    And the user is on the "Your Information" form
    Then the information form is visible










