@login
Feature: User Login

  Background: Open Para Bank Home Page
    Given A user in the home page

  Scenario Outline: User try to login with valid email and password
    When   user enter name and password in fields "<UserName>" "<Password>"
    And    click on the login button
    Then   I'm in the home page
    Examples:
      | UserName     | Password     |
      | Test_UName_1 | Test_Pword_1 |
      | Test_UName_2 | Test_Pword_2 |



  Scenario Outline: User try to login with invalid credentials
    Given  A user in the home page
    When   user enter name and password in fields "<UserName>" "<Password>"
    And    click on the login button
    Then   System displays an error message says "<ErrorMessage>"
    Examples:
      | UserName     | Password     | ErrorMessage                          |
      #Missed UserName
      |              | secret_sauce | Please enter a username and password. |
      #Missed Password
      | mmmm@mmm.com |              | Please enter a username and password. |
      #Missed UserName & Password
      |              |              | Please enter a username and password. |