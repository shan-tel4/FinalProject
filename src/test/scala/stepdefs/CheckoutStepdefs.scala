package stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import org.openqa.selenium.JavascriptExecutor
import pages.CartPage.{errorMessage, loginUser, onInventoryPage, priceTotal}
import pages.CheckoutPage.{addAdditionalProduct, clickBackHomeButton, clickContinueButton, clickFinishButton, errorIconPresent, errorIconsCount, informationFormPresent, inputInvalidPostCode, inputValidFirstName, inputValidLastName, inputValidPostCode, onCheckoutOverviewPage, onOrderConfirmationPage, onYourInformationPage, paymentInfoPresent, priceTotalPresent, shippingInfoPresent}
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
    inputValidFirstName()
    inputValidLastName()
    inputValidPostCode()
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

  Then("""a summary of information is displayed""") { () =>
    paymentInfoPresent()
    shippingInfoPresent()
    priceTotalPresent()
  }

  //  Scenario: Validate Empty Postcode Field Handling For Logged-in User ---> Should fail but is passing

  And("""the user inputs valid first name and last name""") { () =>
    inputValidFirstName()
    inputValidLastName()
  }

  And("""the user inputs invalid post code""") { () =>
    inputInvalidPostCode()
  }

  Then("""the error message and red x icon is displayed for invalid field""") { () =>
    errorMessage()
    errorIconPresent()
    errorIconsCount() == 1
    println(errorIconsCount())
  }

  // Scenario: Successful checkout initiation for Standard User

  Then("""the information form is visible""") { () =>
    informationFormPresent()
  }



}