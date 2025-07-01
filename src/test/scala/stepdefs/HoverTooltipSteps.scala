package stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import pages.AccessibilityPage.{addProductToCart, getTooltipText, hoverOverElement, scrollToBottom, tooltipHasAccessibleLabel, tooltipHasRole}
import pages.CartPage.{loginUser, onInventoryPage}

class HoverTooltipSteps extends ScalaDsl with EN {

  Given("""^The user is successfully logged in$""") { () =>
    loginUser()
  }

  And("""^The user is on the inventory page$""") { () =>
    onInventoryPage()
  }

  Given("""^The user has added a product to the cart$""") { () =>
    addProductToCart()
  }

  Given("""^The user scrolls to the bottom of the page$""") { () =>
    scrollToBottom()
  }

  When("""^The user hovers over the element using selector "([^"]*)"$""") { (cssSelector: String) =>
    hoverOverElement(cssSelector)
  }
  Then("""^The user sees a tooltip with the text "([^"]*)"$""") { (expectedTooltip: String) =>
    val actual = getTooltipText()
    assert(actual == expectedTooltip, s"Expected tooltip text '$expectedTooltip', but got '$actual'")
  }
  Then("""^the tooltip element has role="tooltip"$""") { (expectedTooltip: String) =>
    assert(tooltipHasRole("tooltip"), s"The tooltip should have role tooltip, but it does not")
  }
  And("""^the tooltip element has aira-label or aria-describedby matching "([^"]*)"$""") { (expectedText: String) =>
    assert(tooltipHasAccessibleLabel(expectedText), s"The tooltip should have an accessible label, but it does not")
  }

}
