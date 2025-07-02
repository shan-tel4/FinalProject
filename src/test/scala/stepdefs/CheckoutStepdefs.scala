package stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import org.openqa.selenium.JavascriptExecutor
import pages.CartPage.{loginUser, onInventoryPage}
import pages.CheckoutPage.{addAdditionalProduct, clickBackHomeButton, clickContinueButton, clickFinishButton, inputValidCredentials, onCheckoutOverviewPage, onOrderConfirmationPage, onYourInformationPage}
import support.DriverManager.driver

class CheckoutStepdefs extends ScalaDsl with EN {

  // Background


  // Scenario: Validate Successful Purchase Completion and Display of Confirmation Message For Standard User

  And("""adds an additional product""") { () =>
    addAdditionalProduct()
  }

  And("""the user is on the "Your Information" form""") { () =>
    onYourInformationPage()
  }

  And("""the user inputs valid credentials""") { () =>
    inputValidCredentials()
  }

  And("""the user clicks the "Continue" button""") { () =>
    clickContinueButton()
  }

  And("""the user is on the "Checkout Overview" page""") { () =>
    onCheckoutOverviewPage()
  }

  And("""the user clicks the "Finish" button""") { () =>
    clickFinishButton()
  }

  And("""the user is on the "Order Confirmation" page""") { () =>
    onOrderConfirmationPage()
  }

  And("""the user clicks back home""") { () =>
    clickBackHomeButton()
  }


  //  Scenario: Validate checkout summary details for standard user
  Then("""a summary of information is displayed""")  { () =>

  }

}