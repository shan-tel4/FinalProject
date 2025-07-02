package stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import org.openqa.selenium.{By, WebDriver}
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}
import pages.CartPage.{addButtonPresent, addToCart, checkProductIsRemovedFromCartPage, clickCartIcon, clickCheckout, clickContinueShopping, clickRemove, errorMessage, explicitWaitTenSeconds, loginUser, onCartPage, onInventoryPage, productAdded, returnToInventoryPage}

import java.time.Duration

class CartStepDefinitions extends ScalaDsl with EN {

//  val driver: WebDriver = new ChromeDriver()

  // Scenario: User removes product from cart on the cart page

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

  Then("""the product is removed from the cart""") { () =>
    checkProductIsRemovedFromCartPage()
  }


  // Scenario: User removes item from cart on the Inventory page

  And("""the user clicks the "Remove" button on the product while on the Inventory Page""") { () =>
    clickRemove()
  }

  Then("""the product is removed from the cart on the Inventory Page""") { () =>
    addButtonPresent()
  }

  // Scenario: User navigates back to Inventory from the Your Cart page

    //  When("""the user clicks on the cart icon""") { () =>
    //    clickCartIcon()
    //  }

    And("""the user is on the "Your Cart" page""") { () =>
      onCartPage()
    }

    And("""the user clicks the "Continue Shopping" button""") { () =>
      clickContinueShopping()
    }

    // NEEDS TO BE FIXED
    Then("""the user is redirected to the inventory page""") { () =>
      onInventoryPage()
      //    val explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10))
      //    val visible = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inventory_container")))
    }


  //  Scenario: Standard user attempts to check out with an empty cart -- This should fail

  When("""the user clicks cart icon without adding any products""") { () =>
    clickCartIcon()
  }

//  And("""the user is on the "Your Cart" page""") { () =>
//    onCartPage()
//  }

  And("""the user clicks “Checkout” button""") { () =>
    clickCheckout()
  }

  Then("""an error message is displayed on the screen""") { () =>
    errorMessage()
  }


}
