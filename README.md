# xray-test-automation-example
Studying usage of Xray (JIRA plugin)


# demo
- clone the project
- go to directory of the project after clone
- execute below command (change values for -D parameters, what you see below is dummy data)
```
mvn clean verify -DjiraRootURL=https://jira.johndoeinc.com -DjiraUsername=johndoe -DjiraPassword=ilovejanedoe -DjiraIssueKeys=ABC-123;ABC-456
```
Read more about configuration details in wiki: url

# requirements
- Java (```java -version``` to test)
- Maven (```mvn -v``` to test)
- cURL (WinOS)(```curl``` in cmd to test, install cURL info: http://www.confusedbycode.com/curl/)
- cURL (Linux)(```curl``` in terminal, ```sudo apt-get install curl``` to install, have not tested!) 
- Chrome (test project has chromedriver binary, but one must have Chrome installed for driver to work https://sites.google.com/a/chromium.org/chromedriver/getting-started )

# tool stack details
- Test Runner: Maven Surefire + JUnit + Cucumber JVM
- Test Repository: Xray JIRA plugin
- Test Reporting: maven-cucumber-reporting: https://github.com/damianszczepanik/maven-cucumber-reporting
