package locators

import org.openqa.selenium.By

object LoginLocators {

  // Login Page
  val Username: By = By.name("user-name")
  val Password: By = By.name("password")
  val Submit:   By = By.name("input[type='submit']") //login-button

}
