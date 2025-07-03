package pages

import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}
import org.openqa.selenium.{By, JavascriptExecutor, WebElement}
import pages.CartPage.{cartIconNumber, cartQuantity, driver}
import testdata.Data.{firstName, invalidPostCode, lastName, postCode}

import java.time.Duration


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

  def inputValidFirstName(): Unit = {
    inputText(By.id("first-name"), firstName)

    println("Valid first name input")
  }

  def inputValidLastName(): Unit = {
    inputText(By.id("last-name"), lastName)

    println("Valid last name input")
  }

  def inputValidPostCode(): Unit = {
    inputText(By.id("postal-code"), postCode)

    println("Valid post code input")
  }

  def inputInvalidPostCode(): Unit = {
    inputText(By.id("postal-code"), invalidPostCode)
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

  def checkoutProductListPresent(): Boolean = {
    driver.findElement(By.className("cart_list")).isDisplayed
  }

  def paymentInfoPresent(): Boolean = {
    driver.findElement(By.cssSelector("[data-test='payment-info-label']")).isDisplayed
    driver.findElement(By.cssSelector("[data-test='payment-info-value']")).isDisplayed
  }

  def shippingInfoPresent(): Boolean = {
    driver.findElement(By.cssSelector("[data-test='shipping-info-label']")).isDisplayed
    driver.findElement(By.cssSelector("[data-test='shipping-info-value']")).isDisplayed
  }

  def priceTotalPresent(): Boolean = {
    driver.findElement(By.cssSelector("[data-test='total-info-label']")).isDisplayed
    driver.findElement(By.cssSelector("[data-test='subtotal-label']")).isDisplayed
    driver.findElement(By.cssSelector("[data-test='tax-label']")).isDisplayed
    driver.findElement(By.cssSelector("[data-test='total-label']")).isDisplayed
  }

  def errorIconPresent(): Unit = {
    driver.findElement(By.cssSelector("[data-icon='times-circle']")).isDisplayed
  }

  def errorIconsCount(): Int = {
    driver.findElements(By.cssSelector("[data-icon='times-circle']")).size()
  }

  def informationFormPresent(): Unit = {
    driver.findElement(By.className("checkout_info")).isDisplayed
    println("Form is visible")
  }
  def errorMessagePresent(): Unit = {
    val wait = new WebDriverWait(driver, Duration.ofSeconds(5))
    val error = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div.error-message-container.error > h3"))))
    assert(error.isDisplayed, "Expected error message to be visible but it was not.")
    println("Error message is displayed: " + error.getText)
  }


}

