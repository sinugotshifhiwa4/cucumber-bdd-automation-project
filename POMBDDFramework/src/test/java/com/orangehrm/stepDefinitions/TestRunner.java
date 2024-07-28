package com.orangehrm.stepDefinitions;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/bdd/features"},
        glue = {"com/orangehrm/stepDefinitions"},
        plugin = {"pretty", "json:target/cucumber-reports/Cucumber.json"},
        monochrome = true
)

public class TestRunner {
}
