package stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import org.openqa.selenium.{By, WebDriver}
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}
import java.time.Duration

class LogOutSteps extends ScalaDsl with EN {
  val driver: WebDriver = new ChromeDriver()

  Given("""the user is logged into the Swag Lab page""") { () =>
    driver.get("https://www.saucedemo.com/")
    driver.manage().window().maximize()

    val usernameField = driver.findElement(By.id("user-name"))
    val passwordField = driver.findElement(By.id("password"))
    val loginButton = driver.findElement(By.id("login-button"))

    usernameField.clear()
    passwordField.clear()
    usernameField.sendKeys("standard_user")
    passwordField.sendKeys("secret_sauce")
    loginButton.click()

    // Optional: Confirm login succeeded
    val header = driver.findElement(By.className("title")).getText
    assert(header == "Products", s"Expected 'Products' page but got '$header'")
  }

  When("""the user clicks the burger menu icon""") { () =>
    val wait = new WebDriverWait(driver, Duration.ofSeconds(5))
    val menuButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("react-burger-menu-btn")))
    menuButton.click()
  }

  And("""the user clicks the log out button""") { () =>
    val wait = new WebDriverWait(driver, Duration.ofSeconds(5))
    val logoutLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link")))
    logoutLink.click()
  }

  Then("""the user should successfully log out""") { () =>
    val currentUrl = driver.getCurrentUrl
    assert(currentUrl.contains("saucedemo.com"), "Expected to be back on the login page after logout.")

  }
}
