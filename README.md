# xray-test-automation-example
Proof of Concept study of Xray (JIRA plugin)


# demo
- clone the project
- go to directory of the project after clone
- execute below command (change values for -D parameters, what you see below is dummy data)
```
mvn clean verify -DjiraRootURL=https://jira.johndoeinc.com -DjiraUsername=johndoe -DjiraPassword=ilovejanedoe -DjiraIssueKeys=ABC-123;ABC-456
```
Configuration wiki: https://github.com/kristapsmelderis/xray-test-automation-example/wiki/Configuration

Test report should be visible in: ```target/cucumber-html-reports/feature-overview.html```

If all goes well, your "Test Execution" plan in JIRA-Xray should be updated with status. You can pass just the Test Execution issueKey and import should get all the children issues and report back on their status.

# requirements
- Java (```java -version``` to test)
- Maven (```mvn -v``` to test)
- cURL (WinOS)(```curl``` in cmd to test, install cURL info: http://www.confusedbycode.com/curl/)
- cURL (Linux)(```curl``` in terminal, ```sudo apt-get install curl``` to install, have not tested!) 
- Chrome (test project has chromedriver binary, but one must have Chrome installed for driver to work https://sites.google.com/a/chromium.org/chromedriver/getting-started )

# tool stack details
- Code: Java + selenium-java
- Test Runner: Maven Surefire + JUnit + Cucumber JVM
- Test Repository: Xray JIRA plugin
- Test Reporting: maven-cucumber-reporting: https://github.com/damianszczepanik/maven-cucumber-reporting

#troubleshooting
- if you installed cURL, but it is still not found when running the project, might be because of .exe extension (if you are on Linux, replace ```"curl.exe"``` with ```"curl"``` in ImportUtils class)
