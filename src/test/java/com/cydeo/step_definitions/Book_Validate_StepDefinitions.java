package com.cydeo.step_definitions;

import com.cydeo.pages.Book_Validate_Page;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.sql.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class Book_Validate_StepDefinitions {
    Book_Validate_Page bookValidatePage = new Book_Validate_Page();
    @Given("I am on the login page")
    public void ı_am_on_the_login_page() {
        Driver.getDriver().get("http://library1.cybertekschool.com/");
    }
    @Given("I login to application as a librarian")
    public void ı_login_to_application_as_a_librarian() {
      bookValidatePage.inputEmail.sendKeys("librarian180@library");
      bookValidatePage.inputPassword.sendKeys("OTnz2koH");
    bookValidatePage.sign_in_button.click();
    }
    @Given("I navigate to {string} page")
    public void ı_navigate_to_page(String string) {
    bookValidatePage.booksLink.click();
        
    }
    @When("I open book {string}")
    public void ı_open_book(String bookName) {
     bookValidatePage.searchBox.sendKeys(bookName+ Keys.ENTER);
     bookValidatePage.editBookButton.click();
       
    }
    @Then("book information must match the database for {string}")
    public void book_information_must_match_the_database_for(String bookName) throws SQLException {
        BrowserUtils.sleep(2);
    String actual_bookName = bookValidatePage.bookNameBox.getAttribute("value");
    String actual_ISBN_Box = bookValidatePage.ISBN_Box.getAttribute("value");
    String actual_yearBox = bookValidatePage.yearBox.getAttribute("value");
        BrowserUtils.sleep(1);
    String actual_authorBox = bookValidatePage.authorBox.getAttribute("value");
        BrowserUtils.sleep(1);

        System.out.println("actual_authorBox = " + actual_authorBox);
        System.out.println("actual_bookName = " + actual_bookName);
        System.out.println("actual_yearBox = " + actual_yearBox);
        System.out.println("actual_ISBN_Box = " + actual_ISBN_Box);

        String query = "select name, isbn, year, author from books\n" +
        "where name = '"+bookName+"'";
        Connection connection = DriverManager.getConnection("jdbc:mysql://34.230.35.214:3306/library1", "library1_client","WVF4NdGXCKHeE6VQ");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        ResultSetMetaData rsmd = resultSet.getMetaData();


        Map<String, Object> row = new LinkedHashMap<>();
        resultSet.next();
        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
             row.put(rsmd.getColumnName(i), resultSet.getObject(i));            
        }

        String expected_bookName = row.get("name").toString();
        String expected_ISBN_Box = row.get("isbn").toString();
        String expected_yearBox = row.get("year").toString();
        String expected_authorBox = row.get("author").toString();

        System.out.println("expected_authorBox = " + expected_authorBox);
        System.out.println("expected_bookName = " + expected_bookName);
        System.out.println("expected_ISBN_Box = " + expected_ISBN_Box);
        System.out.println("expected_yearBox = " + expected_yearBox);

        Assert.assertTrue("Actual and expected results doesn't match",actual_bookName.equals(expected_bookName));
        Assert.assertTrue("Actual and expected results doesn't match",actual_ISBN_Box.equals(expected_ISBN_Box));
        Assert.assertTrue("Actual and expected results doesn't match",actual_yearBox.equals(expected_yearBox));
        Assert.assertTrue("Actual and expected results doesn't match",actual_authorBox.equals(expected_authorBox));

    }
}
