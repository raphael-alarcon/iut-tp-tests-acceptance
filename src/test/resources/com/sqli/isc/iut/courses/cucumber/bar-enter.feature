Feature: The bar

  Background:
    Given a group of people go to the bar Le Juste, which is a cocktail bar
      But there are only 10 seats in the bar

    Scenario: Refused entry due to full bar
      When they arrive and there are already 9 people in the bar
      Then the entry is refused because the bar is full

    Scenario: Allowed entry
      Given Mr Pignon goes to the bar Le Juste alone
        And there are already 9 people in the bar
      When he is allowed to enter the bar
      Then he is happy because he is the last person to enter the bar
        And someone else tries to enter the bar
        But he can't because the bar is full

    Scenario Outline: Enter the bar
      Given <guests> people go to the bar Le Juste
        And there are only <seats> seats in the bar
      When <guests> people arrive and there are already <people> people in the bar
      Then there is enough room for <guests> guests the entry is <status>


      Examples:
        | people | seats  | guests  | status   |
        | 8      | 10     | 2       | allowed  |
        | 9      | 10     | 1       | refused  |
        | 10     | 10     | 0       | allowed  |

    Scenario: Order cocktails
      Given they arrive and there are already 8 people in the bar
        And they are allowed to enter the bar
        But the person behind them cannot enter because the bar is full
      When they each order a cocktail of the month at 10€
        And Mr  pays for everything
      Then at the end of their drinks, the bill is checked
        And Mr Leblanc pays
        And Mr Pignon is happy because they only had one drink (due to Mr Pignon's liver issues)





