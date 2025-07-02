package pages

import org.openqa.selenium.By


object CheckoutPage extends BasePage {

  //  val driver: WebDriver = DriverManager.driver

  def addAdditionalProduct(): Unit = {
    driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click()
  }

  def onYourInformationPage() = {

  }
}

