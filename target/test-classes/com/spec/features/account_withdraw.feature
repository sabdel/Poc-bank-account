 Feature: In order to retrieve some or all of my savings
         As a bank client
         I want to make a withdrawal from my account

  Background: 
  Given An existing client  "Toto" with 1000.0 euros in his account and 200.0 as overdraft
     
  Scenario Outline: Withdraws money from account 
    When he withdraws <amount>  from his account 
    Then his new balance should be <balance> 

  Examples:
 | amount     | balance   |
 |  500.0     |  500.0    |
 |  1100.0    |  -100.0   |
 |  1400.0    |  1000.0   |    
    
  
  

   
  
 