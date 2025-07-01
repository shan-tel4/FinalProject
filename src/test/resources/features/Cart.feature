Feature: Cart functionality

  Background:
    Given the user has successfully logged in
    And is on the inventory page

  Scenario: User removes product from cart on the cart page
    When the user clicks the "Add to cart" button on a product
    And the product is added to the cart
    And the user clicks on the cart icon
    And the user clicks the "Remove" button on a product while on the Your Cart Page
    Then the product is removed from the cart

  Scenario: User removes item from cart on the Inventory page
    When the user clicks the "Add to cart" button on a product
    And the product is added to the cart
    And the user clicks the "Remove" button on the product while on the Inventory Page
    Then the product is removed from the cart on the Inventory Page

  Scenario: User navigates back to Inventory from the Your Cart page
    When the user clicks on the cart icon
    And the user is on the "Your Cart" page
    And the user clicks the "Continue Shopping" button
    Then the user is redirected to the Inventory page

