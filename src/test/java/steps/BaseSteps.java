package steps;

import manager.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.qameta.allure.Step;

/**
 * Created By Kolesov Alexandr 20.10.2019
 */
public class BaseSteps {

    @After(order = 1)
    public synchronized void quit(){
        DriverManager.closeBrowser();
    }

    @Step("User get browser as {0}")
    @Given("User get browser as (.*)")
    public void userGetBrowserAsBrowser(String browser) {
        DriverManager.setBrowser(browser);
    }

}
