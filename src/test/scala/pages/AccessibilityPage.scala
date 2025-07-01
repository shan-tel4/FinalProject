package pages

import locators.AccessibilityLocators.{addToCartBackpack, genericTooltip}
import org.openqa.selenium.By.ByCssSelector
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.{By, JavascriptExecutor}
import testdata.Data.{passwordText, usernameText}
import utils.WaitUtils

object AccessibilityPage extends BasePage {


  WaitUtils.setImplicitWait(driver, 5)



  def addProductToCart(): Unit = {
    clickOn(addToCartBackpack)
  }

  def scrollToBottom(): Unit = {
    val js: JavascriptExecutor = driver.asInstanceOf[JavascriptExecutor]
    js.executeScript("window.scrollTo(0, document.body.scrollHeight)")
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
tooltip.getAttribute("role") == role
  }

  def tooltipHasAccessibleLabel(expectedText: String): Boolean = {
    val tooltip = driver.findElement(genericTooltip)
    val ariaLabel = Option(tooltip.getAttribute("aria-label"))
    val ariaDescribedBy = Option(tooltip.getAttribute("aria-describedby"))
    ariaLabel.contains(expectedText) || ariaDescribedBy.contains(expectedText)
  }



}
