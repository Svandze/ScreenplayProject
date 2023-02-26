Feature: Google navigation

  Scenario Outline: Trying to validate pages titles on searcher
    Given User opens navigator
    When input "<information>" on searcher
    Then he will get return containing that string

    Examples:
      | information |
      | Google      |
      | Wikipedia   |
      | Yahoo       |


