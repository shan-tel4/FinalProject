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
    Then the user is redirected to the inventory page

    # Failed test
  Scenario: Standard user attempts to check out with an empty cart
    When the user clicks cart icon without adding any products
    And the user is on the "Your Cart" page
    And the user clicks “Checkout” button
    Then an error message is displayed on the screen

  Scenario: User views cart page with no products added
    When the user clicks cart icon without adding any products
    And the user is on the "Your Cart" page
    Then no products are listed

  Scenario: Standard user adds item to cart
    When the user clicks the "Add to cart" button on a product
    Then the cart icon increases to 1

    # Failed test
  Scenario: User views products in cart
    When the user clicks the "Add to cart" button on a product
    And the cart icon increases to 1
    And the user clicks on the cart icon
    And the user is on the "Your Cart" page
    And a list of products is displayed
    Then the total price is displayed

  Scenario: Verify Standard User can add multiple items to cart up to the maximum limit
    When the user clicks add to cart for all 6 items
    And the cart icon updates to show current number of items stored
    Then all "Add to Cart" buttons change to "Remove" buttons