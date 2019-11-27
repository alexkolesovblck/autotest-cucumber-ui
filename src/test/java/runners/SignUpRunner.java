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
        plugin = {"pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"},
        monochrome = true
)

public class SignUpRunner extends AbstractTestNGCucumberTests {

}
