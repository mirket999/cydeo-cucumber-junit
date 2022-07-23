package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Book_Validate_Page {
    public Book_Validate_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(id = "inputEmail")
    public WebElement inputEmail;

    @FindBy(id = "inputPassword")
    public WebElement inputPassword;

    @FindBy(xpath = "//button[.='Sign in']")
    public WebElement sign_in_button;

    @FindBy(linkText = "Books")
    public WebElement booksLink;

    @FindBy(xpath = "//input[@type=\"search\"]")
    public WebElement searchBox;

    @FindBy(xpath = "//a[@onclick='Books.edit_book(30)']")
    public WebElement editBookButton;

    @FindBy(name = "name")
    public WebElement bookNameBox;

    @FindBy(name = "isbn")
    public WebElement ISBN_Box;

    @FindBy(name = "year")
    public WebElement yearBox;

    @FindBy(xpath = "(//input[@type='text'])[4]")
    public WebElement authorBox;




}
