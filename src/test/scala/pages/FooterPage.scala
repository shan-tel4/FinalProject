package pages

import locators.FooterLocators.{iconSelectors, rightsReservedLocator}
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.WebDriverWait

import java.time.Duration
import scala.jdk.CollectionConverters.SetHasAsScala


object FooterPage extends BasePage {

  def clickOnIconByName(icon: String): Unit = {
val selector = iconSelectors.getOrElse(icon,throw new NoSuchElementException(s"No selector defined for icon: $icon"))
    driver.findElement(By.cssSelector(selector)).click()

  }

  def validateNewTab(expectedUrl: String): Boolean = {
    val allTabs = driver.getWindowHandles.asScala.toSet
    assert(allTabs.size == 2, s"Expected 2 tabs, but found ${allTabs.size}")

    val originalTab = driver.getWindowHandle
    val newTab = allTabs.find(_ != originalTab).getOrElse(throw new RuntimeException("New tab not found"))

    driver.switchTo().window(newTab)

    val actualUrl = driver.getCurrentUrl
    val result = actualUrl.startsWith(expectedUrl)

    driver.close()
    driver.switchTo().window(originalTab)

    result

  }

  def verifyLinkTextVisible(linkText: String): Boolean = {

    findByLinkText(linkText).isDisplayed

  }

  def verifyFooterText(footerText: String): Boolean = {

    findByCssSelector(rightsReservedLocator).getText.contains(footerText)

  }


}
