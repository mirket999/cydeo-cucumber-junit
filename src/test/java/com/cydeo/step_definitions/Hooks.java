package com.cydeo.step_definitions;

import com.cydeo.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    @Before
    public void setupScenario() {
        System.out.println("setting up browser using cucumber @Before");
    }

    @Before (value = "@login")
    public void setupScenarioForLogin() {
        System.out.println("===============only for scenarios for @login");
    }

    @After
    public void teardownScenario() {
    byte [] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);

        Driver.getDriver().close();




    }




//    @BeforeStep
//    public void setuoStep() {
//        System.out.println("--------------------applying setup using @BeforeStep");
//    }
//
//    @AfterStep
//    public void afterStep(){
//        System.out.println("---------------- applying tear down using @AfterStep");
    }

