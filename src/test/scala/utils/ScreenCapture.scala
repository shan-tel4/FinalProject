package utils

import io.cucumber.scala.Scenario
import org.openqa.selenium.io.FileHandler
import org.openqa.selenium.{NoSuchElementException, OutputType, TakesScreenshot, WebDriver, WebElement}
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date


object ScreenCapture {
  val projectPath: String = System.getProperty("user.dir")
  val screenshotDir = new File(projectPath + "/screenshots")

  if (!screenshotDir.exists()) {
    screenshotDir.mkdirs()
  }


  def takeScreenshot(driver: WebDriver): Unit = {

    val timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date())
    val srcTimestamp: File = driver.asInstanceOf[TakesScreenshot].getScreenshotAs(OutputType.FILE)
    val fileName = s"Screenshot_${timeStamp}.png"
    val destFile = new File(screenshotDir, fileName)
    FileHandler.copy(srcTimestamp, destFile)

  }

  def captureFailure(scenario: Scenario, driver: WebDriver): Unit = {
    if (scenario.isFailed) {
      val src: File = driver.asInstanceOf[TakesScreenshot].getScreenshotAs(OutputType.FILE)
      val timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date())
      val fileName = s"Screenshot_Of_Failed_Test_${timeStamp}.png"
      val destFile = new File(screenshotDir, fileName)
      FileHandler.copy(src, destFile)
      println("Screenshot taken")

    }


  }


}