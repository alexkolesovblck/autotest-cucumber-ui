package pages.mainPage;

import commons.SeleniumMethods;
import driverManager.DriverManager;
import io.cucumber.datatable.DataTable;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import pages.BasePage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static commons.TestTools.replaceString;

/**
 * Created By Alexandr Kolesov 26.11.2019
 */
public class MainPage extends BasePage  {

    private final Map<String, By> mainPageMap = new HashMap<String, By>(){};
    private SeleniumMethods methods = new SeleniumMethods();
    private WebDriver driver;

    private String invalidField(String text) { return "//span[contains(@class, 'iqInput__error')]//span[contains(text(), '" + text + "')]"; }

    public MainPage(){
        this.driver = DriverManager.getDriver();

        mainPageMap.put("Начать торговать", By.cssSelector("[data-test-id='intro-trade-now'] > span"));
        mainPageMap.put("Учебный счет", By.cssSelector("[data-test-id='intro-practice-account'] > span"));
        mainPageMap.put("Mail.ru", By.cssSelector("button[data-test-id*='mailru']"));
        mainPageMap.put("Логин на стороне Mail.ru", By.cssSelector("input#login"));
        mainPageMap.put("Пароль на стороне Mail.ru", By.cssSelector("input#password"));
        mainPageMap.put("Войти и разрешить на стороне Mail.ru", By.cssSelector("button[type='submit']"));

        mainPageMap.put("Выбор языка", By.cssSelector("button[data-test-id*='lang-menu']"));
        mainPageMap.put("Русский", By.xpath("//div[@data-test-id='lang-menu-list']//a[contains(@href, '/ru')]"));

        mainPageMap.put("Окно регистрации", By.cssSelector("[aria-label='Auth Modal']"));
        mainPageMap.put("Регистрация", By.cssSelector("button[data-test-id*='header-register']"));
        mainPageMap.put("Войти", By.cssSelector("button[data-test-id*='header-login']"));
        mainPageMap.put("Авторизоваться", By.cssSelector("button[data-test-id*='login-submit']"));

        mainPageMap.put("Имя", By.cssSelector("input[name='first_name']"));
        mainPageMap.put("Фамилия", By.cssSelector("input[name='last_name']"));
        mainPageMap.put("E-mail", By.cssSelector("input[name='email']"));
        mainPageMap.put("Пароль", By.cssSelector("input[name='password']"));
        mainPageMap.put("Я принимаю «Положения и условия» и подтверждаю, что мне 18 лет или больше.",
                By.xpath("//div[@data-test-id='register-checkbox-input']//div[@class]"));

        mainPageMap.put("Открыть счет бесплатно", By.cssSelector("button[data-test-id*='register-submit']"));
        mainPageMap.put("Ошибка регистрации", By.cssSelector("[data-test-id*='register-error']"));
        mainPageMap.put("Ошибка входа", By.cssSelector("[data-test-id*='login-error'] > span"));
        mainPageMap.put("Неверный e-mail", By.xpath(invalidField("Неверный e-mail")));
        mainPageMap.put("Неверный пароль", By.xpath(invalidField("Пароль должен быть длиной не менее 6 символов и содержать хотя бы 1 букву и 1 цифру")));
        mainPageMap.put("Поле не заполнено", By.xpath(invalidField("Поле не заполнено")));

        mainPageMap.put("Имя пользователя", By.cssSelector("div.SidebarProfile__UserName"));
        mainPageMap.put("E-mail пользователя", By.cssSelector("div.SidebarProfile__UserEmail"));
    }

    @Step("User open page {0}")
    public void openPage(String url){
        driver.get("https://" + url);
    }

    @Step("User click on element {0}")
    public void clickOnElement(String webElement){
        methods.clickOnElement(getWebElements(mainPageMap, webElement));
    }

    @Step("User click on element {0}")
    public void setText(String text, String webElement){
        methods.setText(getWebElements(mainPageMap, webElement), replaceString(text.toLowerCase()));
    }

    @Step("User get text from element {0}")
    public String getText(String webElement){
        return methods.readText(getWebElements(mainPageMap, webElement));
    }

    public Boolean languageIs(String webElement) {
        clickOnElement("Выбор языка");
        return getWebElement(mainPageMap, webElement).getAttribute("data-active").equals("true");
    }

    @Step("Check field on web element from table {0}")
    public void assertAllInTable(DataTable table){
        SoftAssert softAssert = new SoftAssert();
        List<Map<String, String>> signForms = table.asMaps();

        for (Map<String, String> form : signForms) {
            String actual = getText(form.get("Field"));
            String expected = replaceString(form.get("Value"));
            softAssert.assertEquals(actual, expected, "\nActual text '" + actual +
                    "' and expected '" + expected + "' is not equals");
        }
        softAssert.assertAll();
    }
}
