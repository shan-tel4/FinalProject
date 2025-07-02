package stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import pages.ProductPage.{selectSortOption, verifyProductsSorted}

class ProductsSteps extends ScalaDsl with EN {


  When("""the user selects {string} from the sort dropdown""") { (option: String) =>
    selectSortOption(option)
  }
  Then("""the products should be sorted by {string}""") { (option: String) =>
    assert(verifyProductsSorted(option), s"Products were not sorted correctly by $option")
  }


}