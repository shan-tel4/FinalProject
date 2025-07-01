package pages

import locators.AccessibilityLocators.{addToCartBackpack, genericTooltip}
import org.openqa.selenium.By.ByCssSelector
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.{By, JavascriptExecutor}
import testdata.Data.{passwordText, usernameText}
import utils.WaitUtils

object AccessibilityPage extends BasePage {

  val js: JavascriptExecutor = driver.asInstanceOf[JavascriptExecutor]
  WaitUtils.setImplicitWait(driver, 5)

  def loginUser(): Unit = {

    driver.get("https://www.saucedemo.com/")
    driver.manage().window().maximize()
    driver.findElement(By.id("user-name")).sendKeys(usernameText)
    driver.findElement(By.id("password")).sendKeys(passwordText)
    driver.findElement(By.id("login-button")).click()
    println("Logged in")

  }

  def addProductToCart(): Unit = {
    clickOn(addToCartBackpack)
  }

  def scrollToBottom(): Unit = {
    js.executeScript("arguments[0].scrollTo(0, document.body.scrollHeight)")
  }

  def hoverOverElement(cssSelector: String): Unit = {
    val element = findByCssSelector(cssSelector)
    val actions = new Actions(driver)
    actions.moveToElement(element).perform()

  }

  def getTooltipText(): String = {
    val tooltip = driver.findElement(genericTooltip)
    tooltip.getText
  }

  def tooltipHasRole(role: String): Boolean = {
    val tooltip = driver.findElement(genericTooltip)

  }

  def tooltipHasAccessibleLabel(): Boolean = {

  }

}
