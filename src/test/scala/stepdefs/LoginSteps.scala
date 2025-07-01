package stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import org.openqa.selenium.{By, WebDriver}
import org.openqa.selenium.chrome.ChromeDriver

class LoginSteps extends ScalaDsl with EN {
  val driver: WebDriver = new ChromeDriver()


  //SUCCESSFUL LOGIN WITH VALID USERNAME AND PASSWORD
  Given("""the user is on the Swag Lab page""") { () =>
    driver.get("https://www.saucedemo.com/")
    driver.manage().window().maximize()

  }

  When("""the user enters valid username and password""") { () =>
    driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user")
      driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce")

  }

  And("""the user clicks the login button""") { () =>
    driver.findElement(By.cssSelector("#login-button")).click()
  }

  Then("""the user is logged in successfully""") { () =>
    val actualHeader = driver.findElement(By.className("title")).getText
    val expectedHeader = "Products"

    assert(actualHeader == expectedHeader, s"Expected header '$expectedHeader', but got '$actualHeader'")

    driver.quit()
  }


  // FAILED LOGIN WITH INVALID USERNAME AND PASSWORD

  When("""the user enters an invalid username and password""") { () =>
    driver.findElement(By.cssSelector("#user-name")).clear()
    driver.findElement(By.cssSelector("#password")).clear()
    driver.findElement(By.cssSelector("#user-name")).sendKeys("Sarah")
    driver.findElement(By.cssSelector("#password")).sendKeys("Password1234")
  }

  Then("""an error message is displayed on the login page""") { () =>
    val errorElement = driver.findElement(By.cssSelector("h3[data-test='error']"))
    assert(errorElement.isDisplayed, "Expected an error message to be displayed, but it was not.")
  }

  And("""the user is not logged in""") { () =>
    val currentUrl = driver.getCurrentUrl
    assert(currentUrl.contains("saucedemo.com"), "Expected user to stay on the login page.")
    driver.quit()
  }

  // FAILED LOGIN WITH INVALID USERNAME AND VALID PASSWORD


}
