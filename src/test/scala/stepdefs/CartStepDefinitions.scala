package stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import locators.LoginLocators.Password
import org.openqa.selenium.{By, WebDriver}
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}
import pages.LoginPage.{browserLaunch, clickOn, getText, inputPassword, inputUserName}
import testdata.Data.{passwordText, usernameText}
import utils.ScreenCapture.takeScreenshot

import java.time.Duration

class CartStepDefinitions extends ScalaDsl with EN {

  val driver: WebDriver = new ChromeDriver()

  driver.get("https://www.saucedemo.com/")
  driver.manage().window().maximize()

  Given("""the user has successfully logged in""") { () =>
    driver.findElement(By.id("user-name")).sendKeys(usernameText)
    driver.findElement(By.id("password")).sendKeys(passwordText)
    driver.findElement(By.id("login-button")).click()
    println("Logged in")
  }

  And("""is on the inventory page""") { () =>
    val inventoryContainer = driver.findElement(By.id("inventory_container"))
    assert(inventoryContainer.isDisplayed, "Inventory page is not displayed")
    println("On inventory page")
  }

  // add in assertions

  When("""the user clicks the "Add to cart" button on a product""") { () =>
    println(driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).isDisplayed)
    driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click()
    println("Clicked add to cart on Bolt T-shirt")

    //    val wait = new WebDriverWait(driver, Duration.ofSeconds(10))
    //    wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-sauce-labs-bolt-t-shirt")))
    //    driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click()
    // clickOn(By.id("add-to-cart-sauce-labs-bolt-t-shirt"))
  }

  And("""the product is added to the cart""") { () =>
    val shoppingCartBadge = driver.findElement(By.className("shopping_cart_badge"))
    shoppingCartBadge.isDisplayed
    println("Shopping cart badge displayed")
  }

  And("""the user clicks on the cart icon""") { () =>
    driver.findElement(By.className("shopping_cart_link")).click()
    println("Shopping cart icon clicked")
    // clickOn(By.className("shopping_cart_link"))
  }

  And("""the user clicks the "Remove" button on a product""") { () =>
    driver.findElement(By.id("remove-sauce-labs-bolt-t-shirt")).click()
    println("Removed Bolt T-shirt")
    // clickOn(By.id("remove-sauce-labs-bolt-t-shirt"))
  }

  Then("""the product is removed from the cart""") { () =>
    val noCartItems = driver.findElement(By.className("removed_cart_item"))
    noCartItems.isDisplayed
    println("Product removed")
  }

  driver.quit()

}