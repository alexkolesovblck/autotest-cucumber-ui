package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.mainPage.MainPage;

public class StepDefinitions {

    private MainPage mainPage = new MainPage();

    @Given("User open '(.*)' page")
    public void userOpenPage(String urlPage) {
        mainPage.openPage(urlPage);
    }

    @When("User click on '(.*)'")
    public void userClickOnWebElement(String webElement) {
        mainPage.clickOnElement(webElement);
    }

    @And("User set text '(.*)' in '(.*)' field")
    public void userSetText(String text, String webElement) {
        mainPage.setText(text, webElement);
    }

    @Then("User see message text '(.*)' on field '(.*)'")
    public void userSeeMessageTextOnField(String text, String webElement) {
        Assert.assertEquals(mainPage.getText(webElement), text, "Text is not equals");
    }

    @Given("User set language as '(.*)'")
    public void userSetLanguage(String lang) {
        if (!mainPage.languageIs(lang))
            userClickOnWebElement(lang);
    }

    @Then("User see field with value where:")
    public void userSeeFieldWithValueWhere(DataTable table) {
        mainPage.assertAllInTable(table);
    }
}
