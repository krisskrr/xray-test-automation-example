package com.kristapsmelderis.examples.config;

public class SystemProperties {
    public static String CHROMEDRIVER_BINARY_PATH = System.getProperty("chromedriverBinaryPath", "src/test/resources/chromedriver.exe").toLowerCase();

    public static String JIRA_ROOT_URL = System.getProperty("jiraRootURL", "https://jira.atlassian.com").toLowerCase();
    public static String JIRA_USERNAME = System.getProperty("jiraUsername", "remember_to_set_system_property_for_jiraUsername").toLowerCase();
    public static String JIRA_PASSWORD = System.getProperty("jiraPassword", "remember_to_set_system_property_for_jiraPassword");
    public static String JIRA_ISSUE_KEYS = System.getProperty("jiraIssueKeys", "remember_to_set_system_property_for_jiraIssueKeys_like_ABC-123;ABC-456");

    public static String IMPORTED_SCENARIO_DIRECTORY = System.getProperty("importedScenarioDirectory", "target/TestsImportedFromJira");
    public static String CUCUMBER_JSON_REPORT_FILEPATH = System.getProperty("cucumberJsonReportFilepath", "target/cucumber.json");
}