Feature: feature to teast google search functionallty

  Scenario: Validate google search is working
    Given browser is open
    And user is on search page
    When user enters a text in search box
    And hits enter
    Then user is navigated to search results
