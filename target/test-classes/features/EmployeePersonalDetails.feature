@tag
Feature: EmployeePersonalDetails

  Scenario: Modify Employee Personal Details
    Given User wants to log in HRMS page
    When User logged in with valid admin credential
    And User clicks the PIM dropdown
    And User clicks the Employee List
    And User navigated to Employee List page
    When User enters valid employee Id "14063"
    And User clicks the search button
    And User clicks the displayedd id 
    Then User navigated to Personal Detail Page
    And User click the Edit button
    When clear the firstName and lastName
    When User types the Driver License Number
    When User modify License expiry date
    When User types the SSN numer
    When User selects the gender
    When User selects the nationality
    Then User clicks the Save button
    

 
