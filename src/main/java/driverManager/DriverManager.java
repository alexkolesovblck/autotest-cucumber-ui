package driverManager;

import io.github.bonigarcia.wdm.WebDriverManagerException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created By Kolesov Alexandr 20.10.2019
 */
public class DriverManager {

    private static WebDriver driver;
    public static WebDriver getDriver() {
        return driver;
    }

    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static void setBrowser(String browser) {
        if (driver == null) {
            switch (browser) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "opera":
                    driver = new OperaDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                default:
                    throw new WebDriverManagerException("Please use case: 'chrome', 'opera' or 'firefox'");
            }

            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        }
    }
}


