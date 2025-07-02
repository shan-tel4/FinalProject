package stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import org.openqa.selenium.{By, WebDriver}
import org.openqa.selenium.chrome.ChromeDriver
import pages.CartPage.{driver, errorMessage, loginUser, onInventoryPage}
import pages.LoginPage.{clickLogin, validPassword, validUsername}

class LoginSteps extends ScalaDsl with EN {


  Given("""the user is on the Swag Lab page""") { () =>
    loginUser()

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
    errorMessage()

  }
}
