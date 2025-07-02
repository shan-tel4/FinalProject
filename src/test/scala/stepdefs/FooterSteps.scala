package stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import pages.FooterPage.{clickOnIcon, validateNewTab, verifyFooterText, verifyLinkTextVisible}

class FooterSteps extends ScalaDsl with EN {

  When("""the user clicks on the {string} icon using the selector {string}""") { (icon: String, cssSelector: String) =>
    clickOnIcon(cssSelector)
  }

  Then("""the company {string} page opens in a new tab with {string} url""") { (icon: String, expectedUrl: String) =>
    assert(validateNewTab(expectedUrl), s"Expected URL to start with: $expectedUrl")
  }

  Then("""^The "([^"]*)" link is visible in the footer$""") { (linkText: String) =>
    assert(verifyLinkTextVisible(linkText), s"The $linkText link is not visible in the footer")
  }

  Then("""^The "2025 Sauce Labs. All Rights Reserved." text is visible in the footer$""") { () =>
    assert(verifyFooterText("2025 Sauce Labs. All Rights Reserved."), s"The 2025 Sauce Labs. All Rights Reserved. text is not visible in the footer")
  }


}
