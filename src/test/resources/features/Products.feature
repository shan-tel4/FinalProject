Feature: Product Sorting

  Background:
    Given The user is successfully logged in
    And The user is on the inventory page

  Scenario Outline: User selects a sorting option from the dropdown

    When the user selects "<option>" from the sort dropdown
    Then the products should be sorted by "<option>"

    Examples:
      | option              |
      | Name (A to Z)       |
      | Name (Z to A)       |
      | Price (low to high) |
      | Price (high to low) |


