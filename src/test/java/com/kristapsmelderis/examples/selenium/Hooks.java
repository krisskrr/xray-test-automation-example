package com.kristapsmelderis.examples.selenium;

import cucumber.api.java.Before;

import static com.kristapsmelderis.examples.selenium.Driver.driver;

public class Hooks {
    @Before
    public void beforeScenario() {
        if (driver != null) {
            Driver.getDriver();
        } else {
            Driver.initChromeDriver();
        }
    }
}