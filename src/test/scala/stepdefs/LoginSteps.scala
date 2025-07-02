package stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import pages.CartPage.onInventoryPage
import pages.LoginPage.{clickLogin, loginErrorMessage, navigateToLoginPage, validPassword, validUsername}

class LoginSteps extends ScalaDsl with EN {


  Given("""the user is on the Swag Lab page""") { () =>
    navigateToLoginPage()
  }

  When("""the user enters username {string} and password {string}""") { (username: String, password: String) =>
    validUsername(username)
    validPassword(password)
  }


  And("""the user clicks the login button""") { () =>
    clickLogin()
  }

  Then("""the user is logged in successfully""") { () =>
    onInventoryPage()
  }

  Then("""an error message is displayed on the login page""") { () =>
  loginErrorMessage()
  }
}
