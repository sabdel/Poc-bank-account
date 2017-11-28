 Feature: In order to retrieve some or all of my savings
         As a bank client
         I want to make a withdrawal from my account

  Background: 
    Given An existing client named "Toto" with 1000.0 euros in his account
     
  Scenario Outline: Withdraws money from account 
    When he withdraws <amount>  from his account
    And  has <overdraft> 
    Then his new balance should be <balance> 

  Examples:
 | amount      | overdraft| balance   |
 |  500.0      | 200      |  500.0    |
 |  -1200.0    | 200      |  -100.0   |
 |  -1400.0    | 200      |  1000.0   |    
    
  
  

   
  
 