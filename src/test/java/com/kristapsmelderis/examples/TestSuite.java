package com.kristapsmelderis.examples;

import com.kristapsmelderis.examples.selenium.Driver;
import com.kristapsmelderis.examples.utils.ImportUtils;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import static com.kristapsmelderis.examples.config.SystemProperties.*;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources"},
        glue = {"com.kristapsmelderis.examples.stepdefs", "com.kristapsmelderis.examples.selenium.Hooks"},
        format = {"html:target/cucumber", "json:target/cucumber.json"}
)
public class TestSuite {

    @BeforeClass
    public static void testSetup() {
        ImportUtils.makeDirectory(IMPORTED_SCENARIO_FILEPATH);
        ImportUtils.curlJIRA(JIRA_USERNAME, JIRA_PASSWORD, JIRA_ROOT_URL, JIRA_ISSUE_KEYS, IMPORTED_SCENARIO_FILEPATH + "/output.feature");
        Driver.initChromeDriver();
    }


    @AfterClass
    public static void teardown() {
        Driver.quitDriver();
    }
}