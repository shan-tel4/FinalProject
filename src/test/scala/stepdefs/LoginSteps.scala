package stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import org.openqa.selenium.{By, WebDriver}
import org.openqa.selenium.chrome.ChromeDriver
import pages.CartPage.driver

class LoginSteps extends ScalaDsl with EN {


  Given("""the user is on the Swag Lab page""") { () =>
    driver.get("https://www.saucedemo.com/")
    driver.manage().window().maximize()
  }

  When("""the user enters username {string} and password {string}""") { (username: String, password: String) =>
    val usernameField = driver.findElement(By.cssSelector("#user-name"))
    val passwordField = driver.findElement(By.cssSelector("#password"))

    usernameField.clear()
    passwordField.clear()

    usernameField.sendKeys(username)
    passwordField.sendKeys(password)
  }

  And("""the user clicks the login button""") { () =>
    driver.findElement(By.cssSelector("#login-button")).click()
  }

  Then("""the user is logged in successfully""") { () =>
    val actualHeader = driver.findElement(By.className("title")).getText
    val expectedHeader = "Products"
    assert(actualHeader == expectedHeader, s"Expected header '$expectedHeader', but got '$actualHeader'")

  }

  Then("""an error message is displayed on the login page""") { () =>
    val errorElement = driver.findElement(By.cssSelector("h3[data-test='error']"))
    assert(errorElement.isDisplayed, "Expected an error message to be displayed, but it was not.")

  }
}
