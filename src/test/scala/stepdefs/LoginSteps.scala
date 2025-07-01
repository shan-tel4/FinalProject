package stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import org.openqa.selenium.{By, WebDriver}
import org.openqa.selenium.chrome.ChromeDriver

class LoginSteps extends ScalaDsl with EN {
  val driver: WebDriver = new ChromeDriver()


  //Validate Successful login with valid username and password
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

  Then("""the user should be logged in successfully""") { () =>
    val actualHeader = driver.findElement(By.className("title")).getText
    val expectedHeader = "Products"

    assert(actualHeader == expectedHeader, s"Expected header '$expectedHeader', but got '$actualHeader'")

    driver.quit()
  }


  //Failed Login With Invalid Username and Valid password for Standard User
  Given("""the user is on the Swag Lab page""") { () =>
    driver.get("https://www.saucedemo.com/")
    driver.manage().window().maximize()

  }

  When("""the user enters an invalid username and password""") { () =>
    driver.findElement(By.cssSelector("#user-name")).sendKeys("Sarah")
    driver.findElement(By.cssSelector("#password")).sendKeys("Password1234")

  }

  And("""the user clicks the login button""") { () =>
    driver.findElement(By.cssSelector("#login-button")).click()
  }

  Then("""an error message should be displayed""") { () =>

    And("""the user should remain on the login page""") { () =>

      driver.quit()
    }
  }
}
