package locators

import org.openqa.selenium.By

object LoginLocators {

  // Login Page
  val usernameField: String = "#user-name"
  val passwordField: By = By.cssSelector("#password")
  val Submit: By = By.name("input[type='submit']") //login-button
  val inventoryContainer: By = By.id("inventory_container")

}
