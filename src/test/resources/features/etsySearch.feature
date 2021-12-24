@etsy @regression #this is  a tag
Feature: User etsy search
  As a User when I enter search for an item I should see the results.


  Scenario: User search for  wooden spoon
    Given User is on Etsy home page
    Then page title should be as a expected
    When User searches for wooden spoon
    Then Page title should start with wooden spoon

    Scenario: Users empty search

      Given User is on Etsy home page
      Then page title should be as a expected
      When User searches for empty value
      Then All categories should be displayed
