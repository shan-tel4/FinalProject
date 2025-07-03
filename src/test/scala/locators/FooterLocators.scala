package locators

object FooterLocators {

  val rightsReservedLocator = "footer > div.footer_copy"
  val iconSelectors: Map[String, String] = Map(
    "Facebook" -> "li.social_facebook > a",
    "Twitter" -> "li.social_twitter > a",
    "LinkedIn" -> "li.social_linkedin > a",
  )

}
