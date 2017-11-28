Feature: In order to check my operations
As a bank client
I want to see the history (operation, date, amount, balance) of my operations


Scenario: Multiple Deposit  Withdraw and ask the statement balance
    
    Given I deposit 100.0 euros
    And I withdraw 50.0 euros
    When I ask the statement
    Then sMy balance should be 50.0
    