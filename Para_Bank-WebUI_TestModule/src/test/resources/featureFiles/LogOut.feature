@logout
Feature: User Login

  Background: Open Para Bank Home Page
    Given A user in the home page

  Scenario Outline: User try to logout from home screen
    When user enter name and password in fields "<UserName>" "<Password>"
    And  click on the login button
    And  Click on Logout
    Then A user in the home page
    Examples:
      | UserName     | Password     |
      | Test_UName_1 | Test_Pword_1 |
