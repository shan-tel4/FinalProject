@Accessibility @Tooltip @WIP
Feature: Hover tooltips for accessibility

  Background:
    Given The user is successfully logged in
    And The user is on the inventory page

  Scenario Outline: Tooltip appears and is accessible when hovering over "<elementName>"
    When The user hovers over the element using selector "<cssSelector>"
    Then The user should see a tooltip with the text "<tooltipText>"
    And the tooltip element should have role="tooltip"
    And the tooltip element should have aira-label or aria-describedby matching "<tooltipText>"

    Examples:
      | elementName        | cssSelector           | tooltipText                         |
      | Add-To_cart Button | li.social_twitter > a | Add To Cart                         |
      | Product Image      | li.social_twitter > a | More Details On Sauce Labs Backpack |
      | Product Title      | li.social_twitter > a | More Details On Sauce Labs Backpack |
      | Sort Dropdown      | li.social_twitter > a | Sort Products                       |
      | Cart Icon          | li.social_twitter > a | Your Cart                           |
      | Menu Icon          | li.social_twitter > a | Open Menu                           |


  @RequiresItemInCart
  Scenario Outline: Tooltip appears and is accessible when hovering over cart related element "<elementName>"
    Given  The user has added a product to the cart
    When The user hovers over the element using selector "<cssSelector>"
    Then The user should see a tooltip with the text "<tooltipText>"
    And the tooltip element should have role="tooltip"
    And the tooltip element should have aira-label or aria-describedby matching "<tooltipText>"

    Examples:
      | elementName   | cssSelector           | tooltipText      |
      | Remove Button | li.social_twitter > a | Remove From Cart |

  @RequiresScroll
  Scenario Outline: Tooltip appears and is accessible when hovering over footer related element "<elementName>"
    Given  The user scrolls to the bottom of the page
    When The user hovers over the element using selector "<cssSelector>"
    Then The user should see a tooltip with the text "<tooltipText>"
    And the tooltip element should have role="tooltip"
    And the tooltip element should have aira-label or aria-describedby matching "<tooltipText>"

    Examples:
      | elementName | cssSelector | tooltipText |
      | LinkedIn Icon      | li.social_twitter > a | LinkedIn                            |
      | Facebook Icon      | li.social_twitter > a | Facebook                            |
      | Twitter Icon       | li.social_twitter > a | Twitter                             |
