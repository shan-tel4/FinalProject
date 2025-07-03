@accessibility @tooltip @wip @regression
Feature: Hover Tooltips for Accessibility

  Background:
    Given The user is successfully logged in
    And The user is on the inventory page

  Scenario Outline: Tooltip appears and is accessible when hovering over "<elementName>"
    When The user hovers over the element using selector "<cssSelector>"
    Then The user sees a tooltip with the text "<tooltipText>"
    And the tooltip element has role="tooltip"
    And the tooltip element has aira-label or aria-describedby matching "<tooltipText>"

    Examples:
      | elementName        | cssSelector                      | tooltipText                         |
      | Add-To_cart Button | #add-to-cart-sauce-labs-backpack | Add To Cart                         |
      | Product Image      | #item_4_img_link                 | More Details On Sauce Labs Backpack |
      | Product Title      | #item_4_title_link               | More Details On Sauce Labs Backpack |
      | Sort Dropdown      | select.product_sort_container    | Sort Products                       |
      | Cart Icon          | a.shopping_cart_link             | Your Cart                           |
      | Menu Icon          | #react-burger-menu-btn           | Open Menu                           |


  @requiresItemInCart
  Scenario Outline: Tooltip appears and is accessible when hovering over cart related element "<elementName>"
    Given  The user has added a product to the cart
    When The user hovers over the element using selector "<cssSelector>"
    Then The user sees a tooltip with the text "<tooltipText>"
    And the tooltip element has role="tooltip"
    And the tooltip element has aira-label or aria-describedby matching "<tooltipText>"

    Examples:
      | elementName   | cssSelector                 | tooltipText      |
      | Remove Button | #remove-sauce-labs-backpack | Remove From Cart |

  @requiresScroll
  Scenario Outline: Tooltip appears and is accessible when hovering over footer related element "<elementName>"
    Given  The user scrolls to the bottom of the page
    When The user hovers over the element using selector "<cssSelector>"
    Then The user sees a tooltip with the text "<tooltipText>"
    And the tooltip element has role="tooltip"
    And the tooltip element has aira-label or aria-describedby matching "<tooltipText>"

    Examples:
      | elementName   | cssSelector            | tooltipText |
      | LinkedIn Icon | li.social_linkedin > a | LinkedIn    |
      | Facebook Icon | li.social_facebook > a | Facebook    |
      | Twitter Icon  | li.social_twitter > a  | Twitter     |
