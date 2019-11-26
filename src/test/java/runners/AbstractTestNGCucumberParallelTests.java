package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.DataProvider;

/**
 * Created By Alexandr Kolesov 26.11.2019
 */
public class AbstractTestNGCucumberParallelTests extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        System.out.println("AbstractTestNGCucumberParallelTests--->Scenarios");
        return super.scenarios();
    }
}
