@googleScenarioOutline
Feature: Data driven testing using Scenario outline with Examples table

  Scenario Outline: Google capital cities search
  Given User is on Google home page
    When User searches for "<country>"
    Then User should see "<capital>" in the result
    Examples:
      |  country| capital|
      |Turkey   | Ankara|
      |Azerbaijan| Baku|
      | USA    | Washington, D.C. |
      | Ukraine | Kyiv |
      | Turkmenistan| Ashgabat |
      | Latvia | Riga |
      | Uzbekistan | Tashkent |
      | Eritrea | Asmara |




