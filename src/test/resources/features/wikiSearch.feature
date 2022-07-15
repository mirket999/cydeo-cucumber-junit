@wikiSearch
Feature: Wikipedia search functionality and verifications

  #WSF-45234 --> potential jira ticket number
  @smoke
  Scenario: Wikipedia Search Functionality Title Verification
    Given User is on Wikipedia home page
    When User types "Bill Gates" in the wiki search box
    And User clicks wiki search button
    Then User sees "Bill Gates" is in the wiki title

  Scenario: Wikipedia Search Functionality Header Verification
    Given User is on Wikipedia home page
    When User types "Steve Jobs" in the wiki search box
    And User clicks wiki search button
    Then User sees "Steve Jobs" is in the main header

  @scenarioOutline
  Scenario Outline: Wikipedia Search Functionality Title Verification
    Given User is on Wikipedia home page
    When User types "<searchValue>" in the wiki search box
    And User clicks wiki search button
    Then User sees "<expectedTitle>" is in the wiki title
    Then User sees "<expectedMainHeader>" is in the main header


    @scientists
    Examples:
      | searchValue  | expectedTitle | expectedMainHeader |
      | Marie Curie  | Marie Curie   | Marie Curie        |
      | Lady Gaga    | Lady Gaga     | Lady Gaga          |
      | Kate Winslet | Kate Winslet  | Kate Winslet       |

  @soccerPlayers
  Examples:
    | searchValue  | expectedTitle | expectedMainHeader |
    | Marie Curie  | Marie Curie   | Marie Curie        |
    | Lady Gaga    | Lady Gaga     | Lady Gaga          |
    | Kate Winslet | Kate Winslet  | Kate Winslet       |

      #to beautify the pipes above
      #mac: command + option + L
      #windows: control + alt + L