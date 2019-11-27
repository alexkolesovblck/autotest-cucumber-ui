package manager;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created By Alexandr Kolesov 06.10.2019
 */
public class SeleniumManager {

    private WebElement element;
    private String text;
    private List<WebElement> elements;
    private int timeOut = 30;

    /**
     * Поиск элемента по локатору, использующий ожидание
     * @param locator
     * @return WebElement
     */
    public WebElement findElement(By locator) {
        webDriverWait(locator).until((driver -> {
            element = driver.findElement(locator);
            return true;
        }));
        return element;
    }

    private WebDriverWait webDriverWait(Object locator){
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), timeOut);
        wait.ignoring(StaleElementReferenceException.class);
        wait.ignoring(ElementNotInteractableException.class);
        wait.ignoring(ElementClickInterceptedException.class);
        wait.ignoring(ElementNotVisibleException.class);
        wait.ignoring(NoSuchElementException.class);
        wait.withMessage("Could not find element by " + locator + " in " + timeOut + " second");
        return wait;
    }

    /**
     * Поиск элементов по локатору, использующий ожидание
     * @param locator
     * @return List<WebElement>
     */
    public List<WebElement> findElements(By locator) {
        webDriverWait(locator).until((driver) ->
        {
            elements = driver.findElements(locator);
            return elements.size() > 0;
        });
        return elements;
    }

    /**
     * Получить текст у вебэлемента
     * @param elements
     * @return String
     */
    public String readText(List<WebElement> elements) {
        webDriverWait(element).until((driver) ->
        {
            for (WebElement element: elements) {
                if(element.isDisplayed()){
                    text = element.getText();

                    if (text == null)
                        text = element.getAttribute("value");
                }
            }
            return true;
        });
        return text;
    }

    /**
     * Нажать на видимый элемент
     * @param elements
     */
    public void clickOnElement(List<WebElement> elements){
        webDriverWait(elements).until((driver) ->
        {
            for (WebElement element: elements) {
                if(element.isDisplayed()){
                    element.click();
                }
            }
            return true;
        });
    }

    /**
     * Отправить выбранный текст в поле и снять фокус в элемента
     * @param elements
     * @param text
     */
    public void setText(List<WebElement> elements, String text){
        webDriverWait(elements).until((driver) ->
        {
            for (WebElement element: elements) {
                if(element.isDisplayed()){
                    element.click();
                    element.clear();
                    element.sendKeys(text);
                }
            }
            return true;
        });
    }

    /**
     * Снять фокус с элемента
     * @param element
     */
    public void removeFocus(WebElement element)
    {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].blur();",30, element);
    }

}
