package com.kristapsmelderis.examples;

import com.kristapsmelderis.examples.selenium.Driver;
import com.kristapsmelderis.examples.utils.Utils;
import cucumber.api.CucumberOptions;
import com.kristapsmelderis.examples.utils.MyCucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import static com.kristapsmelderis.examples.config.SystemProperties.*;


@RunWith(MyCucumber.class)
@CucumberOptions(
        features = {"src/test/resources", "target/TestsImportedFromJira"},
        glue = {"com.kristapsmelderis.examples.stepdefs", "com.kristapsmelderis.examples.selenium.Hooks"},
        format = {"html:target/cucumber", "json:target/cucumber.json"}
)
public class TestSuite {

    @BeforeClass
    public static void testSetup() {
        Driver.initChromeDriver();
    }


    @AfterClass
    public static void teardown() {
        Driver.quitDriver();
        Utils.exportReportToJIRA(JIRA_USERNAME, JIRA_PASSWORD, JIRA_ROOT_URL, CUCUMBER_JSON_REPORT_FILEPATH);
    }
}