package locators

import org.openqa.selenium.By

object LoginLogoutLocators {

  val usernameField: String = "#user-name"
  val passwordField: String = "#password"
  val Submit: String = "input[type='submit']" //login-button
val errorMessage: String = "div.error-message-container.error > h3"
  val menuIcon: String = "react-burger-menu-btn"
  val logoutLinkField: String = "logout_sidebar_link"
  val loginLogo: String = "div.login_logo"
}
