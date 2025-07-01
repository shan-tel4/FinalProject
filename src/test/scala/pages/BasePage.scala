package pages

import org.openqa.selenium.{By, WebDriver, WebElement}
import pages.CartPage.driver
import support.DriverManager
import testdata.Data.{passwordText, usernameText}
import utils.ConfigReader

trait BasePage {
  def driver: WebDriver = DriverManager.driver

  def browserLaunch(): Unit = {
    val testUrl = ConfigReader.get("base.url")
    driver.get(testUrl)
  }

  // Locator Identification
  def findById(id: String): WebElement = driver.findElement(By.id(id))
  def findByName(name: String): WebElement = driver.findElement(By.name(name))
  def findByLinkText(link: String): WebElement = driver.findElement(By.linkText(link))
  def findByPartialLinkText(partialLink: String): WebElement = driver.findElement(By.partialLinkText(partialLink))
  def findByTagName(tag: String): WebElement = driver.findElement(By.tagName(tag))
  def findByCssSelector(css: String): WebElement = driver.findElement(By.cssSelector(css))
  def findByXpath(xpath: String): WebElement = driver.findElement(By.xpath(xpath))

  // Common Actions

  def inputText(selector: By, text: String): Unit =
    driver.findElement(selector).sendKeys(text)

  def clickOn(selector: By): Unit = {
    driver.findElement(selector).click()
  }

  def getText(selector: By): String =
    driver.findElement(selector).getText


  // Methods for Cart

//  def loginUser(): Unit =
//    driver.get("https://www.saucedemo.com/")
//  driver.findElement(By.id("user-name")).sendKeys(usernameText)
//  driver.findElement(By.id("password")).sendKeys(passwordText)
//  driver.findElement(By.id("login-button")).click()
//  println("Logged in")
//
//
//  def onInventoryPage(): Unit = {
//    val inventoryContainer: WebElement = driver.findElement(By.id("inventory_container"))
//    assert(inventoryContainer.isDisplayed, "Inventory page is not displayed")
//    println("On inventory page: " + inventoryContainer.isDisplayed)
//  }
//
//
//  def addToCart(): Unit =
//    driver.findElement(By.linkText("Add to cart")).click()
//  println("Clicked add to cart")
//
//
//  def productAdded(): Unit = {
//    // Check shopping cart badge updates
//    val shoppingCartBadge: WebElement = driver.findElement(By.className("shopping_cart_badge"))
//    assert(shoppingCartBadge.isDisplayed, "Shopping cart badge is not displayed")
//
//    removeButtonPresent()
//
//    println(shoppingCartBadge.getText)
//
//  }
//
//
//  def addButtonPresent(): Unit = {
//    val addToCartButton = driver.findElement(By.linkText("Add to cart"))
//    addToCartButton.isDisplayed
//    println("add to cart button displayed: " + addToCartButton.isDisplayed)
//  }
//
//
//  def removeButtonPresent(): Unit = {
//    val removeButton: WebElement = driver.findElement(By.linkText("Remove"))
//    removeButton.isDisplayed
//    println(removeButton.isDisplayed)
//  }
//
//  def clickCartIcon(): Unit =
//    driver.findElement(By.className("shopping_cart_link")).click()
//  println("Shopping cart icon clicked")
//
//
//  def clickRemove(): Unit =
//    driver.findElement(By.linkText("Remove")).click()
//  println("Removed item")
//
//
//  def checkProductIsRemoved(): Unit = {
//    val removeItem: WebElement = driver.findElement(By.className("removed_cart_item"))
//    removeItem.isDisplayed
//
//    addButtonPresent()
//
//    println("Product removed")
//
//  }
}
