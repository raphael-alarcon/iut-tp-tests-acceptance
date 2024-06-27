Feature: The bar

    Background:
      Given A new bar "Le Juste"
      And "Mr Pignon, Mr Leblanc" go to the bar
      And there are only 10 seats in the bar

    Scenario Outline: Enter the bar
      When there are already <people> people in the bar
        And there is enough room for guests
      Then the entry is <status>

      Examples:
        | people | status   |
        | 8      | allowed  |
        | 9      | refused  |
        | 10     | refused  |
        | 0      | allowed  |

      Scenario: Second scenario
        Given there are already 8 people in the bar
          And there is enough room for guests
          And the entry is allowed
          And the bar is full
          But Another guest tries to enter
          And the entry is refused
        When "Mr Pignon, Mr Leblanc" order 1 "cocktail of the month" at 10e
        Then at the end of their drinks, "Mr Leblanc, Mr Pignon" check the bill
          And "Mr Leblanc" pays for "Mr Leblanc, Mr Pignon"
          And "Mr Pignon" is happy because "they only had one drink (due to Mr Pignon's liver issues)"

      Scenario: Third Scenario
        Given there are already 3 people in the bar
          And there is enough room for guests
          And the entry is allowed
          And "Mr Pignon, Mr Leblanc" order 1 "cocktail of the month" at 10e
        When at the end of their drinks, "Mr Pignon, Mr Leblanc" check the bill
          And "Mr Pignon" pays for "Mr Pignon"
          But "Mr Leblanc" insists to pay another "cocktail of the month" to "Mr Pignon"
          And "Mr Leblanc" order 2 "cocktail of the month" at 10e
        Then at the end of their drinks, "Mr Leblanc" check the bill
          And "Mr Leblanc" pays for "Mr Leblanc, Mr Pignon"
          And "Mr Pignon" is sad because "he knows that more than one drink will make him have a bad night (due to Mr Pignon's liver issues)"





