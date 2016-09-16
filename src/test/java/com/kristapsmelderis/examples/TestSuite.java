package com.kristapsmelderis.examples;

import com.kristapsmelderis.examples.selenium.Driver;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"com.kristapsmelderis.examples.stepdefs", "com.kristapsmelderis.examples.selenium"},
        format = {"json:target/cucumber.json"}
)
public class TestSuite {
    @AfterClass
    public static void teardown() {
        Driver.quitDriver();
    }
}