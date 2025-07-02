package stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import pages.CartPage.{loginUser, onInventoryPage}
import pages.CheckoutPage.addAdditionalProduct

class CheckoutStepdefs extends ScalaDsl with EN {

  // Background

  Given("""the user has successfully logged in""") { () =>
    loginUser()
  }

  And("""is on the inventory page""") { () =>
    onInventoryPage()
  }

  // Scenario: Validate Successful Purchase Completion and Display of Confirmation Message For Standard User

  And("""adds an additional product""") { () =>
    addAdditionalProduct()
  }

  And("""the user is on the "Your Information" form""") { () =>

  }

}