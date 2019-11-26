package runners;

import io.cucumber.testng.CucumberOptions;

/**
 * Created By Alexandr Kolesov 06.10.2019
 */
@CucumberOptions(
        features = "src/test/resources/features/example",
        glue = {"steps"},
        tags = {"~@Ignore"},
        plugin = {"pretty", "html:target/cucumber-reports/example"},
        monochrome = true
)

public class ExampleRunner extends AbstractTestNGCucumberParallelTests {

}