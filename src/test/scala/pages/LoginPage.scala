package pages

import locators.LoginLocators.{passwordField, Submit, usernameField}
import org.openqa.selenium.By

object LoginPage extends BasePage {

//  // — User Name —
//
//  def inputUserName(text: String): Unit =
//    inputText(Username, text)
//
//  // — Password —
//  def inputPassword(text: String): Unit = {
//  }

  // — Submit Button —
  def buttonSubmit(): Unit = {
    clickOn(Submit)
  }

  def validUsername(username: String): Unit = {
    val usernameFieldVal = findByCssSelector(usernameField)


    usernameFieldVal.clear()


    usernameFieldVal.sendKeys(username)
  }


  def validPassword(password: String): Unit = {
    val passwordFieldVal = findByCssSelector("#password")


    passwordFieldVal.clear()


    passwordFieldVal.sendKeys(password)
  }

  def clickLogin(): Unit = {
    driver.findElement(By.cssSelector("#login-button")).click()

  }

  def onInventoryPage(): Unit = {
    val inventoryContainer = driver.findElement(By.id("inventory_container"))
    assert(inventoryContainer.isDisplayed, "Inventory page is not displayed")
  }

  def errorMessage() = {
    val error = driver.findElement(By.cssSelector("error"))
    assert(error.isDisplayed, "Expected error message to be visible but it was not.")
    println("Error message is displayed: " + error.getText)
  }


}
