package com.kristapsmelderis.examples.stepdefs.search;

import cucumber.api.java.en.*;
import org.openqa.selenium.By;

import static com.kristapsmelderis.examples.selenium.Driver.driver;
import static org.junit.Assert.assertTrue;

public class Google {
    @Given("^I navigate to \"([^\"]*)\"$")
    public void i_navigate_to(String stepdefInputURL) throws Throwable {
        driver.get(stepdefInputURL);
    }

    @When("^I enter \"([^\"]*)\"$")
    public void i_enter(String stepdefInputString) throws Throwable {
        driver.findElement(By.id("lst-ib")).sendKeys(stepdefInputString);
    }

    @When("^I click magnifying glass icon$")
    public void i_click_magnifying_glass_icon() throws Throwable {
        driver.findElement(By.className("lsb")).click();
    }

    @Then("^I can find string \"([^\"]*)\" in page$")
    public void i_can_find_string_in_page(String stepdefInputString) throws Throwable {
        String actualPageSource = driver.getPageSource();
        assertTrue("\n\nAssert Fail: Did not find this string in page source: " + stepdefInputString + "\n\n",
                actualPageSource.contains(stepdefInputString));
    }
}