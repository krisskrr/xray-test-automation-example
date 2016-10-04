package com.kristapsmelderis.examples.utils;


import cucumber.api.junit.Cucumber;
import cucumber.runtime.Runtime;
import cucumber.runtime.RuntimeOptions;
import cucumber.runtime.io.ResourceLoader;
import org.junit.runners.model.InitializationError;

import java.io.IOException;

import static com.kristapsmelderis.examples.config.SystemProperties.*;
import static com.kristapsmelderis.examples.config.SystemProperties.IMPORTED_SCENARIO_DIRECTORY;
import static com.kristapsmelderis.examples.config.SystemProperties.JIRA_ISSUE_KEYS;

//Needed to Override Cucumber.createRuntime so that tests from JIRA would be imported before createRuntime collected .features
public class MyCucumber extends Cucumber {
    public MyCucumber(Class clazz) throws InitializationError, IOException {
        super(clazz);
    }
    @Override
    protected Runtime createRuntime(ResourceLoader resourceLoader, ClassLoader classLoader, RuntimeOptions runtimeOptions) throws InitializationError, IOException {
        Utils.makeDirectory(IMPORTED_SCENARIO_DIRECTORY);
        Utils.importTestsFromJIRA(JIRA_USERNAME, JIRA_PASSWORD, JIRA_ROOT_URL, JIRA_ISSUE_KEYS, IMPORTED_SCENARIO_DIRECTORY + "/tests_imported_from_jira.feature");
        return super.createRuntime(resourceLoader, classLoader, runtimeOptions);
    }
}
