package stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import org.openqa.selenium.{By, WebDriver}
import org.openqa.selenium.chrome.ChromeDriver
import pages.CartPage.{addToCart, checkProductIsRemoved, clickCartIcon, clickRemove, loginUser, onInventoryPage, productAdded}


import java.time.Duration

class CartStepDefinitions extends ScalaDsl with EN {

  val driver: WebDriver = new ChromeDriver()

  Given("""the user has successfully logged in""") { () =>
    loginUser()
  }

  And("""is on the inventory page""") { () =>
    onInventoryPage()
  }

  When("""the user clicks the "Add to cart" button on a product""") { () =>
    addToCart()
  }

  And("""the product is added to the cart""") { () =>
    productAdded()
  }

  And("""the user clicks on the cart icon""") { () =>
    clickCartIcon()
  }

  And("""the user clicks the "Remove" button on a product while on the Your Cart Page""") { () =>
    clickRemove()
  }

  And("""the user clicks the "Remove" button on the product while on the Inventory Page""") { () =>
    clickRemove()
  }

  Then("""the product is removed from the cart""") { () =>
    checkProductIsRemoved()
    driver.quit()
  }

  Then("""the product is removed from the cart on the Inventory Page""") { () =>

    driver.quit()
  }

}