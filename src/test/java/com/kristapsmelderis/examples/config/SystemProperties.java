package com.kristapsmelderis.examples.config;


public class SystemProperties {

    public static String CHROMEDRIVER_BINARY_PATH = System.getProperty("chromedriverBinaryPath","src/test/resources/chromedriver.exe");
    public static String JIRA_ROOT_URL = System.getProperty("jiraRootURL","https://jira.atlassian.com");

}
