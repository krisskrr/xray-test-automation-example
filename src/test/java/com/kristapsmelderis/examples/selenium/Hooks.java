package com.kristapsmelderis.examples.selenium;

import cucumber.api.java.Before;
import org.openqa.selenium.JavascriptExecutor;

import static com.kristapsmelderis.examples.selenium.Driver.driver;

public class Hooks {
    @Before
    public void beforeScenario() {
        if (driver instanceof JavascriptExecutor) {
            ((JavascriptExecutor) driver).executeScript("$(document).ajaxStop(function(){0 === $.active});");
        }
        if (driver != null) {
            Driver.getDriver();
        } else {
            Driver.initChromeDriver();
        }
    }
}