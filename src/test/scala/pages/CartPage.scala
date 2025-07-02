package pages

import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}
import org.openqa.selenium.{By, WebDriver, WebElement}
import support.DriverManager
import testdata.Data.{passwordText, usernameText}

import java.time.Duration
import javax.management.modelmbean.RequiredModelMBean
import scala.collection.convert.ImplicitConversions.`collection AsScalaIterable`

object CartPage extends BasePage {

  //  val driver: WebDriver = DriverManager.driver

  def loginUser(): Unit = {
    driver.get("https://www.saucedemo.com/")
    driver.manage().window().maximize()
    driver.findElement(By.id("user-name")).sendKeys(usernameText)
    driver.findElement(By.id("password")).sendKeys(passwordText)
    driver.findElement(By.id("login-button")).click()
    println("Logged in")
  }

  def onInventoryPage(): Unit = {
    val productsTitle = driver.findElement(By.cssSelector("span[data-test='title']"))
    assert(productsTitle.getText == "Products", "Expected page title to be 'Products'")
    println("On Inventory page")
  }

  def returnToInventoryPage(): Unit = {
    val inventoryList = driver.findElement(By.className("inventory-list"))
    assert(inventoryList.isDisplayed, "Inventory page is not displayed")
    println("On Inventory page: " + inventoryList.isDisplayed)
  }

  def onCartPage(): Unit = {
    val productsTitle = driver.findElement(By.cssSelector("span[data-test='title']"))
    assert(productsTitle.getText == "Your Cart", "Expected page title to be 'Your Cart'")
    println("On Your Cart page")

  }

  def addToCart(): Unit = {
    driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click()
    println("Clicked add to cart")
  }

  def cartQuantity(): Int = {
    driver.findElements(By.className("cart_item")).size()
  }

  def cartIconNumber(): Any = {
    val badge = driver.findElement(By.className("shopping_cart_badge"))
    badge.getText.toInt
  }

  def productAdded(): Unit = {
    // Check shopping cart badge updates
    val shoppingCartBadge: WebElement = driver.findElement(By.className("shopping_cart_badge"))
    assert(shoppingCartBadge.isDisplayed, "Shopping cart badge is not displayed")

    removeButtonPresent()

    println(shoppingCartBadge.getText)
  }

  def priceTotal(): WebElement = {
    driver.findElement(By.className("summary_total_label"))
  }


  def addButtonPresent(): Unit = {
    val addToCartButton = driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"))
    addToCartButton.isDisplayed
    println("add to cart button displayed: " + addToCartButton.isDisplayed)
  }


  def removeButtonPresent(): Unit = {
    val removeButton: WebElement = driver.findElement(By.id("remove-sauce-labs-bolt-t-shirt"))
    removeButton.isDisplayed
    println(removeButton.isDisplayed)
  }

  def clickCartIcon(): Unit = {
    driver.findElement(By.className("shopping_cart_link")).click()
    println("Shopping cart icon clicked")
  }


  def clickRemove(): Unit = {
    driver.findElement(By.id("remove-sauce-labs-bolt-t-shirt")).click()
    println("Removed item")
  }

  def clickContinueShopping(): Unit = {
    driver.findElement(By.id("continue-shopping")).click()
    println("Clicked continue shopping")
  }

  def clickCheckout(): Unit = {
    driver.findElement(By.id("checkout")).click()
    println("Checkout Clicked")
  }


  def checkProductIsRemovedFromCartPage(): Unit = {
    val removeItem = driver.findElement(By.className("removed_cart_item"))
    removeItem.isDisplayed
    println("Product removed")
  }

  def explicitWaitTenSeconds(): Unit = {
    val explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10))
  }

  def errorMessage(): Unit = {
    val error = driver.findElement(By.cssSelector("[data-test='error']"))
    assert(error.isDisplayed, "Expected error message to be visible but it was not.")
    println("Error message is displayed: " + error.getText)
  }

  def addAllProducts(): Unit = {
    driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click()
    driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click()
    driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click()
    driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click()
    driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click()
    driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")).click()

    println("All products added")
  }

  def checkSixRemoveButtonsPresent(): Unit = {
    driver.findElement(By.id("remove-sauce-labs-backpack")).isDisplayed
    driver.findElement(By.id("remove-sauce-labs-bolt-t-shirt")).isDisplayed
    driver.findElement(By.id("remove-sauce-labs-onesie")).isDisplayed
    driver.findElement(By.id("remove-sauce-labs-bike-light")).isDisplayed
    driver.findElement(By.id("remove-sauce-labs-fleece-jacket")).isDisplayed
    driver.findElement(By.id("remove-test.allthethings()-t-shirt-(red)")).isDisplayed

    println("All remove buttons present")
  }

}

