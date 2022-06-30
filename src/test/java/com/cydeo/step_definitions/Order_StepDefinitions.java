package com.cydeo.step_definitions;

import com.cydeo.pages.BasePage;
import com.cydeo.pages.OrderPage;
import com.cydeo.pages.ViewAllOrdersPage;
import com.cydeo.pages.WebTableLoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Order_StepDefinitions {
    WebTableLoginPage webTableLoginPage = new WebTableLoginPage();
    OrderPage orderPage = new OrderPage();
    ViewAllOrdersPage viewAllOrdersPage = new ViewAllOrdersPage();

    @Given("user is already logged in and on order page")
    public void user_is_already_logged_in_and_on_order_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("web.Table.Url"));
        webTableLoginPage.loginWithConfig();
        orderPage.orderButton.click();
    }

    @When("user selects product type {string}")
    public void user_selects_product_type(String string) {
        Select select = new Select(orderPage.productDropDown);
        select.selectByVisibleText(string);
    }

    @And("user enters quantity {int}")
    public void userEntersQuantity(int quantity) {
        // orderPage.inputQuantity.sendKeys(Keys.BACK_SPACE);
        orderPage.inputQuantity.sendKeys(Keys.CONTROL + "a");
        orderPage.inputQuantity.sendKeys(Keys.DELETE);
        orderPage.inputQuantity.sendKeys(quantity + "");
    }

    @When("user enters customer name {string}")
    public void user_enters_customer_name(String string) {
        orderPage.inputCostumerName.sendKeys(string);
    }

    @When("user enters street {string}")
    public void user_enters_street(String string) {

        orderPage.inputStreetName.sendKeys(string);
    }

    @When("user enters city {string}")
    public void user_enters_city(String string) {
        orderPage.inputCityName.sendKeys(string);
    }

    @When("user enters state {string}")
    public void user_enters_state(String string) {
        orderPage.inputStateName.sendKeys(string);
    }

    @When("user enters zipcode {string}")
    public void user_enters_zipcode(String string) {
        orderPage.inputZip.sendKeys(string);
    }

    @When("user selects credit card type {string}")
    public void user_selects_credit_card_type(String expectedCardType) {
        BrowserUtils.clickRadioButton(orderPage.radioButtons, expectedCardType);
    }

    @When("user enters credit card number {string}")
    public void user_enters_credit_card_number(String string) {
        orderPage.cardNonput.sendKeys(string);
    }

    @When("user enters expiry date {string}")
    public void user_enters_expiry_date(String string) {
        orderPage.cardExpDate.sendKeys(string);
    }

    @When("user enters process order button")
    public void user_enters_process_order_button() {
        orderPage.processOrderButton.click();
    }

    @Then("user should see {string} in first row of the web table")
    public void user_should_see_in_first_row_of_the_web_table(String expectedFirstCustomerName) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(orderPage.header));
        String actualFirstCustomerName = viewAllOrdersPage.firstRowOfTable_customerName.getText();
        Assert.assertTrue(expectedFirstCustomerName.equalsIgnoreCase(actualFirstCustomerName));
    }


}
