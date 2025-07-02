package pages

import locators.LoginLogoutLocators.{Submit, errorMessage, passwordField, usernameField}
import org.openqa.selenium.By

object LoginPage extends BasePage {

  def navigateToLoginPage(): Unit = {
    driver.get("https://www.saucedemo.com/")
  }

  def validUsername(username: String): Unit = {
    val usernameFieldVal = findByCssSelector(usernameField)
    usernameFieldVal.clear()
    usernameFieldVal.sendKeys(username)
  }


  def validPassword(password: String): Unit = {
    val passwordFieldVal = findByCssSelector(passwordField)
    passwordFieldVal.clear()
    passwordFieldVal.sendKeys(password)
  }

  def clickLogin(): Unit = {
    findByCssSelector(Submit).click()

  }

  def loginErrorMessage(): Unit = {
    val error = findByCssSelector(errorMessage)
    assert(error.isDisplayed, "Expected error message to be visible but it was not.")
    println("Error message is displayed: " + error.getText)
  }


}
