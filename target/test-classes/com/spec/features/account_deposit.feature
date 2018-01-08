Feature: In order to save money As a bank client I want to make a deposit in my account

  Background:
    Given An existing client named "Toto" with 0.0 euros in his account
     
    Scenario Outline: Deposit money into account 
    When he deposits <amount>  into his account
    
    Then the new balance should be <balance> 

  Examples:
 | amount       | balance   |
 |  100.0       |  100.0    |
 |   0.0        |  0.0      |
 |  -100.0      |  0.0      |    
    
  
  
  
 