Feature: In order to check my operations
As a bank client
I want to see the history (operation, date, amount, balance) of my operations


Scenario: Multiple Deposit  Withdraw and show history 
    
    Given I deposit 100 euros  "2000-01-01T00:00:00"
    And   I withdraw 50 euros  "2000-01-02T00:00:00"
    When I ask the statement
    Then history  should be 
    
    |2000-01-01T00:00:00| DEPOSIT   | 100.0 | 100.0 |
    |2000-01-02T00:00:00| WITHDRAWAL| 50.0  | 50.0  |
    
    