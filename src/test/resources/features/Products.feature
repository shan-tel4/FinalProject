Feature: Product Sorting

  Scenario Outline: User selects a sorting option from the dropdown
    Given the user is on the products page
    When the user clicks on the sorting dropdown button
    And the user selects "<option>" from the dropdown
    Then the products should be sorted by "<option>"

    Examples:
      | option              |
      | Name (A to Z)       |
      | Name (Z to A)       |
      | Price (low to high) |
      | Price (high to low) |


