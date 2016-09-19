Feature: Search engines
  As a user
  I would like to search the web using search engines
  So that I could quickly find relevant results

  Scenario: google for "latest tech in IT"
    Given I navigate to "http://google.com"
    When I enter "latest tech in IT"
    And I click magnifying glass icon
    Then I can find string "latest tech in IT" in page