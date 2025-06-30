package support

import io.cucumber.scala.{EN, ScalaDsl, Scenario}
import org.openqa.selenium.chrome.{ChromeDriver, ChromeOptions}
import utils.ScreenCapture


object Hooks extends ScalaDsl with EN {

  val options = new ChromeOptions()
  options.addArguments("--headless=new")
0
  Before {
    println("Launching browser before scenario...")
    DriverManager.driver = new ChromeDriver(options)
    DriverManager.driver.manage().window().maximize()
  }

  After { scenario: Scenario =>
    ScreenCapture.captureFailure(scenario,DriverManager.driver)
    println("Closing browser after scenario...")
    DriverManager.driver.quit()
  }
}
