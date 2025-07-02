@Footer @Regression
Feature: Footer Links and Icons

  Background:
    Given The user is successfully logged in
    And The user is on the inventory page
    And The user scrolls to the bottom of the page

  Scenario Outline: Click on "<icon>" icon in the footer
    When the user clicks on the "<icon>" icon using the selector "<cssSelector>"
    Then the company "<icon>" page opens in a new tab with "<expectedUrl>" url

    Examples:
      | icon     |  | cssSelector            | expectedUrl                                  |
      | Facebook |  | li.social_facebook > a | https://www.facebook.com/saucelabs           |
      | Twitter  |  | li.social_twitter > a  | https://x.com/saucelabs                      |
      | LinkedIn |  | li.social_linkedin > a | https://www.linkedin.com/company/sauce-labs/ |

  @WIP
  Scenario Outline: Verify the "<linkText>" link is visible in the footer
    Then The "<linkText>" link is visible in the footer

    Examples:
      | linkText         |
      | Privacy Policy   |
      | Terms of Service |

  Scenario: Verify the "2025 Sauce Labs. All Rights Reserved." text is visible in the footer
    Then The "2025 Sauce Labs. All Rights Reserved." text is visible in the footer



