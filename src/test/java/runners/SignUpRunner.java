package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * Created By Alexandr Kolesov 26.11.2019
 */
@CucumberOptions(
        features = "src/test/resources/features/signUp",
        glue = {"steps"},
        tags = {"~@Ignore"},
        plugin = {"pretty", "html:target/cucumber-reports/signUp"},
        monochrome = true
)

public class SignUpRunner extends AbstractTestNGCucumberTests {

}
