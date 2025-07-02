package stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import pages.CartPage.loginUser
import pages.ProductPage.{clickLogout, clickMenuIcon, confirmLogout}

class LogOutSteps extends ScalaDsl with EN {


  Given("""the user is logged into the Swag Lab page""") { () =>
    loginUser()
  }

  When("""the user clicks the burger menu icon""") { () =>
   clickMenuIcon()
  }

  And("""the user clicks the log out button""") { () =>
   clickLogout()
  }

  Then("""the user should successfully log out""") { () =>
    confirmLogout()
  }
}
