package pages


import locators.LoginLogoutLocators.{loginLogo, logoutLinkField, menuIcon}
import locators.ProductLocators.{productNameElements, productPriceElements, sortDropdown}
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.{ExpectedConditions, Select, WebDriverWait}
import java.time.Duration
import scala.jdk.CollectionConverters.ListHasAsScala

object ProductPage extends BasePage {

  def clickMenuIcon(): Unit = {
    val wait = new WebDriverWait(driver, Duration.ofSeconds(5))
    val menuButton = wait.until(ExpectedConditions.elementToBeClickable(By.id(menuIcon)))
    menuButton.click()
  }

  def clickLogout(): Unit = {
    val wait = new WebDriverWait(driver, Duration.ofSeconds(5))
    val logoutLink = wait.until(ExpectedConditions.elementToBeClickable(By.id(logoutLinkField)))
    logoutLink.click()
  }

  def confirmLogout(): Unit = {

    assert(findByCssSelector(loginLogo).isDisplayed, "Expected to be back on the login page after logout.")
  }

  def selectSortOption(option: String): Unit = {
    val dropdown = new Select(findByCssSelector(sortDropdown))
    dropdown.selectByVisibleText(option)
  }

  def verifyProductsSorted(option: String): Boolean = {
    val productNames = driver.findElements(By.cssSelector(productNameElements)).asScala.map(_.getText)
    val productPrices = driver.findElements(By.cssSelector(productPriceElements)).asScala.map(_.getText.stripPrefix("$").toDouble)

    option match {
      case "Name (A to Z)" => productNames == productNames.sorted
      case "Name (Z to A)" => productNames == productNames.sorted.reverse
      case "Price (low to high)" => productPrices == productPrices.sorted
      case "Price (high to low)" => productPrices == productPrices.sorted.reverse
    }
  }

}
