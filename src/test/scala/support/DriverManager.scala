package support

import org.openqa.selenium.WebDriver

object DriverManager {
  private var _driver: WebDriver = _

  def driver: WebDriver = _driver

  def setDriver(driverInstance: WebDriver): Unit = {
    _driver = driverInstance

  }
}
