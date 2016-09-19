# xray-test-automation-example
Studying usage of Xray (JIRA plugin)
(actual implementation with Xray pending...)

# demo
```mvn test``` launches tests (Chrome browser will open and perform a search in google search engine);
```
git clone git@github.com:kristapsmelderis/xray-test-automation-example.git
cd xray-test-automation-example
mvn test
```

# requirements
- Java (```java -version``` to test)
- Maven (```mvn -v``` to test)
- Chrome (test project has chromedriver binary, but one must have Chrome installed for driver to work https://sites.google.com/a/chromium.org/chromedriver/getting-started )

# implementation details

JIRA rest java client core dependency.
```
<!-- https://maven-repository.com/artifact/com.atlassian.jira/jira-rest-java-client-core/3.0.0 -->
        <dependency>
            <groupId>com.atlassian.jira</groupId>
            <artifactId>jira-rest-java-client-core</artifactId>
            <version>3.0.0</version>
        </dependency>
```
