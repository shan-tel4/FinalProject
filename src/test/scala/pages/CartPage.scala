package pages

import org.openqa.selenium.{By, WebDriver, WebElement}
import support.DriverManager
import testdata.Data.{passwordText, usernameText}

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
    val inventoryContainer: WebElement = driver.findElement(By.id("inventory_container"))
    assert(inventoryContainer.isDisplayed, "Inventory page is not displayed")
    println("On inventory page: " + inventoryContainer.isDisplayed)
  }


  def addToCart(): Unit = {
    driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click()
    println("Clicked add to cart")
  }



  def productAdded(): Unit = {
    // Check shopping cart badge updates
    val shoppingCartBadge: WebElement = driver.findElement(By.className("shopping_cart_badge"))
    assert(shoppingCartBadge.isDisplayed, "Shopping cart badge is not displayed")

    removeButtonPresent()

    println(shoppingCartBadge.getText)

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



  def checkProductIsRemoved(): Unit = {
    val removeItem: WebElement = driver.findElement(By.className("removed_cart_item"))
    removeItem.isDisplayed

    addButtonPresent()

    println("Product removed")

  }
}

