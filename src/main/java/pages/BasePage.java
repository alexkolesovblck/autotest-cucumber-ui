package pages;

import commons.SeleniumMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

/**
 * Created By Alexandr Kolesov 26.11.2019
 */
public class BasePage {

    private SeleniumMethods methods = new SeleniumMethods();

    public By getBy(Map<String, By> map, String key) {
        if (!map.containsKey(key))
            throw new NullPointerException("Not contain elements with: " + key + "Please, add new key in: " + map);
        return map.get(key);
    }

    public WebElement getWebElement(Map<String, By> map, String key) {
        if (!map.containsKey(key))
            throw new NullPointerException("Not contain elements with: " + key + "Please, add new key in: " + map);
        return methods.findElement(map.get(key));
    }

    public List<WebElement> getWebElements(Map<String, By> map, String key) {
        if (!map.containsKey(key))
            throw new NullPointerException("Not contain elements with: " + key + "Please, add new key in: " + map);
        return methods.findElements(map.get(key));
    }

}
