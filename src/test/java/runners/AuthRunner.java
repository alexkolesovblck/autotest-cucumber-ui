package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * Created By Alexandr Kolesov 26.11.2019
 */
@CucumberOptions(
        features = "src/test/resources/features/auth",
        glue = {"steps"},
        tags = {"~@Ignore"},
        plugin = {"pretty", "html:target/cucumber-reports/auth"},
        monochrome = true
)

public class AuthRunner extends AbstractTestNGCucumberTests {

}
