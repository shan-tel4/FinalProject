package locators

import org.openqa.selenium.By

object AccessibilityLocators {
  val addToCartBackpack: By = By.cssSelector("#add-to-cart-sauce-labs-backpack")
  val productImage: By = By.cssSelector("#item_4_img_link")
  val productTitle: By = By.cssSelector("#item_4_title_link")
  val sortDropdown: By = By.cssSelector("select.product_sort_container")
  val cartIcon: By = By.cssSelector(" a.shopping_cart_link")
  val menuIcon: By = By.cssSelector("#react-burger-menu-btn")
  val removeFromCartBackpack: By = By.cssSelector("#remove-sauce-labs-backpack")
  val linkedinIcon: By = By.cssSelector("li.social_linkedin > a")
  val facebookIcon: By = By.cssSelector("li.social_facebook > a")
  val twitterIcon: By = By.cssSelector("li.social_twitter > a")
  val genericTooltip: By = By.cssSelector(".tooltip")
}
