@registration
Feature: Registration

  Background: Open Para Bank Home Page
    Given A user in the home page

  Scenario Outline: User try to create an account with valid data
    When  Click on Register link
    And   Redirected to continue registration page
    And   Fill all the required fields of personal information section "<FName>" , "<LName>", "<Address>" ,"<City>","<State>","<Zip_Code>","<Phone>","<SSN>","<Username>","<Password>","<Confirm>"
    And   click on Register button
    Then  The account has been created successfully
    Examples:
      | FName      | LName      | Address      | City      | State      | Zip_Code | Phone      | SSN  | Username       | Password      | Confirm       |
      | Test_FName | Test_LName | Test_Address | Test_city | Test_State | 12345    | 1234567675 | 1234 | Test_UserName4 | Test_Password | Test_Password |

  Scenario Outline: Verify user can't register with registered Username
    When  Click on Register link
    And   Redirected to continue registration page
    And   Fill all the required fields of personal information section "<FName>" , "<LName>", "<Address>" ,"<City>","<State>","<Zip_Code>","<Phone>","<SSN>","<Username>","<Password>","<Confirm>"
    And   click on Register button
    Then  System displays an "<ErrorMessage>"beside username field
    Examples:
      | ErrorMessage                  | FName      | LName      | Address      | City      | State      | Zip_Code | Phone      | SSN  | Username       | Password      | Confirm       |
      | This username already exists. | Test_FName | Test_LName | Test_Address | Test_city | Test_State | 12345    | 1234567675 | 1234 | Test_UserName4 | Test_Password | Test_Password |

  Scenario Outline: Verify user can't register with invalid data
    When  Click on Register link
    And   Redirected to continue registration page
    And   Fill all the required fields of personal information section "<FName>" , "<LName>", "<Address>" ,"<City>","<State>","<Zip_Code>","<Phone>","<SSN>","<Username>","<Password>","<Confirm>"
    And   click on Register button
    Then  System displays an "<ErrorMessage>"beside "<Field>"
    Examples:
      | Field      | ErrorMessage                        | FName      | LName      | Address      | City      | State      | Zip_Code | Phone      | SSN  | Username       | Password      | Confirm            |
      | First Name | First name is required.             |            | Test_LName | Test_Address | Test_city | Test_State | 12345    | 1234567675 | 1234 | Test_UserName1 | Test_Password | Test_Password      |
      | Last Name  | Last name is required.              | Test_FName |            | Test_Address | Test_city | Test_State | 12345    | 1234567675 | 1234 | Test_UserName1 | Test_Password | Test_Password      |
      | Address    | Address is required.                | Test_FName | Test_LName |              | Test_city | Test_State | 12345    | 1234567675 | 1234 | Test_UserName1 | Test_Password | Test_Password      |
      | City       | City is required.                   | Test_FName | Test_LName | Test_Address |           | Test_State | 12345    | 1234567675 | 1234 | Test_UserName1 | Test_Password | Test_Password      |
      | State      | City is required.                   | Test_FName | Test_LName | Test_Address | Test_city |            | 12345    | 1234567675 | 1234 | Test_UserName1 | Test_Password | Test_Password      |
      | Zip Code   | Zip Code is required.               | Test_FName | Test_LName | Test_Address | Test_city | Test_State |          | 1234567675 | 1234 | Test_UserName1 | Test_Password | Test_Password      |
      | SSN        | Social Security Number is required. | Test_FName | Test_LName | Test_Address | Test_city | Test_State | 12345    |            |      | Test_UserName1 | Test_Password | Test_Password      |
      | Username   | Username is required.               | Test_FName | Test_LName | Test_Address | Test_city | Test_State | 12345    | 1234567675 | 1234 |                | Test_Password | Test_Password      |
      | Password   | Password is required.               | Test_FName | Test_LName | Test_Address | Test_city | Test_State | 12345    | 1234567675 | 1234 | Test_UserName1 |               | Test_Password      |
      | Confirm    | Password confirmation is required.  | Test_FName | Test_LName | Test_Address | Test_city | Test_State | 12345    | 1234567675 | 1234 | Test_UserName1 | Test_Password |                    |
      | Confirm    | Password confirmation is required.  | Test_FName | Test_LName | Test_Address | Test_city | Test_State | 12345    | 1234567675 | 1234 | Test_UserName1 | Test_Password | Different_Password |