Feature: As a user I want to get ability to open an article page using search

  @smoke
 Scenario: The open article page should have the same name as the clicked item in the search results.
    Given the user opens Cucumber website
    When the user clicks on the search icon
    And the user enters "Announces" to the search field
    And the user clicks on the "Blog" item in the filters section
    And the user opens the first link with the template «"Open Source" | <articleName>» in the search results
    Then the open page has title <articleName>