@update_info
Feature: Update User Contact Info

  Background: Open Para Bank Home Page
    Given A user in the home page

  Scenario Outline: User Can view his/her Accounts and balance successfully
    And  user enter name and password in fields "<UserName>" "<Password>"
    And  click on the login button
    When Click on Update Contact Info to Update User Contact Info
    And   Fill all the required fields of update profile section "<FName>" , "<LName>", "<Address>" ,"<City>","<State>","<Zip_Code>","<Phone>"
    And User clicks on Update profile button
    Then Contact Info Shall be updated successfully
    Examples:
      | UserName       | Password      | FName | LName | Address | City   | State           | Zip_Code | Phone  |
      | Test_UserName1 | Test_Password | Jhon  | Smith | NSW     | Sydney | New South Weals | 7537     | 564281 |


