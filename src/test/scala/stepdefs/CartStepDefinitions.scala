package stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import pages.CartPage.{addAllProducts, addButtonPresent, addToCart, cartIconNumber, cartQuantity, checkProductIsRemovedFromCartPage, checkSixRemoveButtonsPresent, clickCartIcon, clickCheckout, clickContinueShopping, clickRemove, errorMessage, explicitWaitTenSeconds, loginUser, onCartPage, onInventoryPage, priceTotal, productAdded, returnToInventoryPage}

class CartStepDefinitions extends ScalaDsl with EN {

  //  val driver: WebDriver = new ChromeDriver()

  // Background

  Given("""the user has successfully logged in""") { () =>
    loginUser()
  }

  And("""is on the inventory page""") { () =>
    onInventoryPage()
  }


  // Scenario: User removes product from cart on the cart page

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

  And("""the user is on the "Your Cart" page""") { () =>
    onCartPage()
  }

  And("""the user clicks the "Continue Shopping" button""") { () =>
    clickContinueShopping()
  }

  // NEEDS TO BE FIXED
  Then("""the user is redirected to the inventory page""") { () =>
    onInventoryPage()
  }


  //  Scenario: Standard user attempts to check out with an empty cart -- This should fail

  When("""the user clicks cart icon without adding any products""") { () =>
    assert(cartQuantity() == 0, s"Expected 0 items in cart, but got ${cartQuantity()}")
    clickCartIcon()
  }

  And("""the user clicks “Checkout” button""") { () =>
    clickCheckout()
  }

  Then("""an error message is displayed on the screen""") { () =>
    errorMessage()
  }

  // Scenario: User views cart page with no products added

  Then("""no products are listed""") { () =>
    assert(cartQuantity() == 0, s"Expected 0 items in cart, but got ${cartQuantity()}")
    println("Number of items: " + cartQuantity())
  }

  // Scenario: Standard user adds item to cart

  Then("""the cart icon increases to 1""") { () =>
    assert(cartIconNumber() == 1, s"Expected 1 item in cart, but got ${cartIconNumber()}")
    println("Cart icon displays number: " + cartIconNumber())
  }

  // Scenario: User views products in cart --> Should fail

  And("""a list of products is displayed""") { () =>
    assert(cartQuantity() >= 1, s"Expected quantity is 1 or more, but got ${cartIconNumber()}")
    println("Number of items: " + cartQuantity())
  }

  Then("""the total price is displayed""") { () =>
    priceTotal()
  }

  //  Scenario: Verify Standard User can add multiple items to cart up to the maximum limit

  When("""the user clicks add to cart for all 6 items""") { () =>
    addAllProducts()
  }

  And("""the cart icon updates to show current number of items stored""") { () =>
    assert(cartIconNumber() == 6, s"Expected 6 items in cart, but got ${cartIconNumber()}")
  }

  Then("""all "Add to Cart" buttons change to "Remove" buttons""") { () =>
    checkSixRemoveButtonsPresent()
  }

}
