package com.cydeo.step_definitions;

import com.cydeo.pages.DropDownsPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class DataTable_StepDefinition {

    @Then("user should see fruits I like")
    public void user_should_see_fruits_I_like(List<String> fruits) {

            System.out.println(fruits);

    }

    DropDownsPage dropDownsPage = new DropDownsPage();

    @Given("User is on the dropdowns page of practice tool")
    public void user_is_on_the_dropdowns_page_of_practice_tool() {
     Driver.getDriver().get(ConfigurationReader.getProperty("web.DropDown.Url"));
    }
    @Then("User should see below info in month dropdown")
    public void user_should_see_below_info_in_month_dropdown(List<String> expectedMonthsAsString) {
    Select select = new Select(dropDownsPage.monthDropDown);
        List<WebElement> actualMonthsAsWebElement = select.getOptions();
        List<String> actualMonthsAsString = new ArrayList<>();
        for (WebElement eachWebElement : actualMonthsAsWebElement) {
            actualMonthsAsString.add(eachWebElement.getText());
        }
        Assert.assertEquals(expectedMonthsAsString, actualMonthsAsString);
    }

}
