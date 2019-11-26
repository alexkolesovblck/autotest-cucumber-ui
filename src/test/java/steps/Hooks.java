package steps;

import commons.TestLogger;
import driverManager.DriverManager;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import static io.github.bonigarcia.wdm.DriverManagerType.*;

/**
 * Created By Kolesov Alexandr 20.10.2019
 */
public class Hooks {

    @Before
    public void setUp(Scenario scenario){
        WebDriverManager.getInstance(CHROME).setup();
        WebDriverManager.getInstance(OPERA).setup();
        WebDriverManager.getInstance(FIREFOX).setup();

        TestLogger.message( "***************************************************************************", false, false);
        TestLogger.message( "Executing Scenario : " + scenario.getName(), true, false);
        TestLogger.message( "***************************************************************************", false, false);
    }


    @BeforeStep()
    public void beforeStep(Scenario scenario){
        TestLogger.message("\n+ " + scenario.getStatus(), false, false);
    }


    @After(order = 100)
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                TestLogger.error("Scenario FAILED");
                scenario.write(DriverManager.getDriver().getCurrentUrl());
                byte[] screenShot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenShot, "image/png");
            } catch (WebDriverException e) {
                TestLogger.error(e.getMessage());
            }
        }
    }

    @After(order = 10)
    public void afterScenario(Scenario scenario){
        TestLogger.message( "***************************************************************************", false, false);
        TestLogger.message( "Finish Scenario : " + scenario.getName(), true, false);
        TestLogger.message( "***************************************************************************", false, false);
    }
}
