@account
Feature: Account

  Background: Open Para Bank Home Page
    Given A user in the home page

  Scenario Outline: User Can view his/her Accounts and balance successfully
    And  user enter name and password in fields "<UserName>" "<Password>"
    And  click on the login button
    When Click on Accounts overview to display accounts details
    And  Select first account from  displayed accounts
    Then Account details shall be displayed successfully
    Examples:
      | UserName       | Password      |
      | Test_UserName1 | Test_Password |
      | Test_UserName2 | Test_Password |



  Scenario Outline: User can open a new account
    And  user enter name and password in fields "<UserName>" "<Password>"
    And  click on the login button
    When Click on Open new account to create a new account
    And  Select Account type from type list
    And  Click on Create button
    Then New Account shall be opened successfully
    Examples:
      | UserName       | Password      |
      | Test_UserName1 | Test_Password |
