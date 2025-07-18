package runner

import io.cucumber.junit.{Cucumber, CucumberOptions}
import org.junit.runner.RunWith // Import JUnit’s @RunWith annotation to delegate execution to an external runner

@RunWith(classOf[Cucumber]) // Tell JUnit to execute this test suite with Cucumber’s JUnit engine
@CucumberOptions( // Begin Cucumber configuration block
  features = Array("src/test/resources/features"), // Path(s) to your .feature files (Gherkin scenarios)
  glue = Array("stepdefs", "support"), // Packages that contain step definitions, hooks, and other glue code
  tags = "@loginLogout",
  plugin = Array("pretty", //  • “pretty” prints colour‑coded steps to the console
    "html:target/Login-Logout-Tests/Login and Logout Test Report.html" //  • Generates an HTML report at target/cucumber-report.html
  ),
  monochrome = true // Strips ANSI colours from console output for easier reading in plain terminals
) // End of @CucumberOptions block
class LoginLogoutTestRunner // Empty body is fine; class merely acts as a configuration holder
