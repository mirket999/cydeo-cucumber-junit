package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrderPage extends BasePage{
    public OrderPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (name = "product")
    public WebElement productDropDown;

    @FindBy (xpath = "//input[@placeholder='Enter amount desired']")
    public WebElement inputQuantity;

    @FindBy(name = "name")
    public WebElement inputCostumerName;

    @FindBy(name = "street")
    public WebElement inputStreetName;

    @FindBy(name = "city")
    public WebElement inputCityName;

    @FindBy(name = "state")
    public WebElement inputStateName;

    @FindBy(name = "zip")
    public WebElement inputZip;

    @FindBy (xpath = "//input[@type='radio']")
    public List<WebElement> radioButtons;

    @FindBy(name = "cardNo")
    public WebElement cardNonput;

    @FindBy(name = "cardExp")
    public WebElement cardExpDate;



    @FindBy(xpath = "//button[@type='submit']")
    public WebElement processOrderButton;

    @FindBy(tagName = "h1")
    public WebElement header;


    
    
}
