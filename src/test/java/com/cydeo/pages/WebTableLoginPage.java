package com.cydeo.pages;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTableLoginPage {
    public WebTableLoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (name = "username")
    public WebElement inputUsername;

    @FindBy (name = "password")
    public WebElement inputPassword;

    @FindBy (xpath = "//button[.='Login']")
    public WebElement loginButton;



    /**
     * No parameters.
     *
     */
public void loginWithNoParameter(){
    Driver.getDriver().get(ConfigurationReader.getProperty("web.Table.Url"));
    inputUsername.sendKeys("Test");
    inputPassword.sendKeys("Tester");
    loginButton.click();
}

    /**
     * This method accepts two params and logs in
     * @param userName
     * @param password
     */

    public void loginWithParam(String userName, String password){
        Driver.getDriver().get(ConfigurationReader.getProperty("web.Table.Url"));
    inputUsername.sendKeys(userName);
    inputPassword.sendKeys(password);
    loginButton.click();
}

    /**
     * login with no hardcoding
     */
public void loginWithConfig(){
    Driver.getDriver().get(ConfigurationReader.getProperty("web.Table.Url"));
    inputUsername.sendKeys(ConfigurationReader.getProperty("web.table.username"));
    inputPassword.sendKeys(ConfigurationReader.getProperty("web.table.password"));
    loginButton.click();
}

}
