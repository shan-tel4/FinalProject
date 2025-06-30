package stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import pages.LoginPage.browserLaunch

class CartStepDefinitions extends ScalaDsl with EN {

  val driver: WebDriver = new ChromeDriver()

  Given("""the user has successfully logged in""") { ()
    browserLaunch()
  }

  When("""the user clicks the "Add to cart" button on a product""") { ()

  }


}