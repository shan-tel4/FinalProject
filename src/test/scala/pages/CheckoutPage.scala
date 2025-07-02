package pages

import org.openqa.selenium.{By, JavascriptExecutor, WebElement}
import pages.CartPage.{cartIconNumber, cartQuantity, driver}
import testdata.Data.{firstName, lastName, postCode}


object CheckoutPage extends BasePage {

  //  val driver: WebDriver = DriverManager.driver

  def addAdditionalProduct(): Unit = {
    driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click()
    println("Additional product added, number of items: " + cartIconNumber())
  }

  def onYourInformationPage(): Unit = {
    val infoPageTitle = driver.findElement(By.cssSelector("span[data-test='title']"))
    assert(infoPageTitle.getText == "Checkout: Your Information", "Expected page title to be 'Checkout: Your Information'")
    println("On Checkout: Your Information page")
  }

  def onCheckoutOverviewPage(): Unit = {
    val infoPageTitle = driver.findElement(By.cssSelector("span[data-test='title']"))
    assert(infoPageTitle.getText == "Checkout: Overview", "Expected page title to be 'Checkout: Overview'")
    println("On Checkout: Overview page")
  }

  def onOrderConfirmationPage(): Unit = {
    val infoPageTitle = driver.findElement(By.cssSelector("span[data-test='title']"))
    assert(infoPageTitle.getText == "Checkout: Complete!", "Expected page title to be 'Checkout: Complete!'")
    println("On Checkout: Complete! page")
  }

  def inputValidCredentials(): Unit = {
    driver.findElement(By.id("first-name")).sendKeys(firstName)
    driver.findElement(By.id("last-name")).sendKeys(lastName)
    driver.findElement(By.id("postal-code")).sendKeys(postCode)

    println("Valid credentials input")
  }

  def clickContinueButton(): Unit = {
    driver.findElement(By.id("continue")).click()
    println("Continue button clicked")
  }

  def finishButton(): WebElement = {
    driver.findElement(By.id("finish"))
  }

  def clickFinishButton(): Unit = {
    val finishButton = driver.findElement(By.id("finish"))
    val js = driver.asInstanceOf[JavascriptExecutor]
    js.executeScript("arguments[0].scrollIntoView(true);", finishButton)
    js.executeScript("arguments[0].click();", finishButton)

    println("Finish button clicked")
  }

  def clickBackHomeButton(): Unit = {
    driver.findElement(By.id("back-to-products")).click()
  }
}

