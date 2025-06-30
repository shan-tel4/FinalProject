package support

import io.cucumber.scala.{EN, ScalaDsl}
import org.openqa.selenium.chrome.{ChromeDriver, ChromeOptions}

import java.sql.DriverManager


class Hooks extends ScalaDsl with EN {

  val options = new ChromeOptions()
  options.addArguments("--headless=new")

  Before {
    println("Launching browser before scenario...")
    DriverManager.driver = new ChromeDriver(options)
    DriverManager.driver.manage().window().maximize()
  }

  After {
    println("Closing browser after scenario...")
    DriverManager.driver.quit()
  }
}
