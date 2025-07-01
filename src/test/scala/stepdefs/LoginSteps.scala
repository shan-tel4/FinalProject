package stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import org.openqa.selenium.{By, WebDriver}
import org.openqa.selenium.chrome.ChromeDriver

class LoginSteps extends ScalaDsl with EN {
  val driver: WebDriver = new ChromeDriver()

  Given("""the user is on the Swag Lab page""") { () =>
    driver.get("https://www.saucedemo.com/")
  }

  When("""the user enters valid username and password""") { () =>
    driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user")
      driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce")

  }

  And("""the user clicks the login button""") { () =>
    driver.findElement(By.cssSelector("#login-button")).click()
  }

  Then("""the user should be logged in successfully""") { () =>
    val actualHeader = driver.findElement(By.className("title")).getText
    val expectedHeader = "Products"

    assert(actualHeader == expectedHeader, s"Expected header '$expectedHeader', but got '$actualHeader'")

    driver.quit()
  }
}
