#Author: davutseker29@gmail.com
Feature: Sauce Login
  
  
  Description: US-3421 The purpose of this feature file is to automate sauce demo app login feature with valid and invalid credentials
  Acceptance Criteria: I want to automate sauce demo login functionality

  Scenario Outline: invalid login
   When user enter invalid username as "<username>"
    And user enter invalid password as "<password>"
    And click on login button
    Then user should see the error message

  Examples:
  
  |username|	|password|
  |  Admin |	|admin123|
  | sarmed |	|sarmad@ |
