# xray-test-automation-example
Studying usage of Xray (JIRA plugin)


# demo
```
git clone git@github.com:kristapsmelderis/xray-test-automation-example.git
cd xray-test-automation-example
mvn clean verify
```

```mvn clean verify``` launches tests (Chrome browser will open and perform a search in google search engine);

# requirements
- Java (```java -version``` to test)
- Maven (```mvn -v``` to test)
- cURL (WinOS)(```curl``` in cmd to test, install cURL info: http://www.confusedbycode.com/curl/)
- cURL (Linux)(```curl``` in terminal, ```sudo apt-get install curl``` to install, have not tested!) 
- Chrome (test project has chromedriver binary, but one must have Chrome installed for driver to work https://sites.google.com/a/chromium.org/chromedriver/getting-started )

# tool stack details
Test Runner: Maven Surefire + JUnit + Cucumber JVM
Test Repository: Xray JIRA plugin
Test Reporting: maven-cucumber-reporting: https://github.com/damianszczepanik/maven-cucumber-reporting
