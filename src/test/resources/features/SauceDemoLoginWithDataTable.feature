Feature: Sauce Demo login

  Scenario: invalid login
    When user enter invalid username as below
      | username |
      | admin    |
      | regu;ar  |
    And user enter invalid password
    And click on login button
    Then user should see the error message
