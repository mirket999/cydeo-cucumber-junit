package com.cydeo.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = "html:target/cucumber-report.html",
        features = "src/test/resources/features",
        glue = "com/cydeo/step_definitions",
        //dryRun = false,
        //tags = "@Regression"
        //tags = "@librarian or @student"
       //tags = "@employee"
        //tags = "@admin and @employee"
        //tags = "@Regression and not @student"
       tags = "@employee and not @admin"
)
public class CukesRunner {
}
