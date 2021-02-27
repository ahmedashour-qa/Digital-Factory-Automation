@login
Feature: User Login

  Scenario Outline: User try to login with valid email and password
    Given  A user in the home page
    When   user enter name and password in fields "<email>" "<password>"
    And    click on the login button
    Then   I'm in the home page
    Examples:
      | email        | password  |
      | standard_user| secret_sauce |
      | problem_user| secret_sauce |
      | performance_glitch_user| secret_sauce |


  Scenario Outline: User try to login with invalid credentials
    Given  A user in the home page
    When   user enter name and password in fields "<email>" "<password>"
    And    click on the login button
    Then   In "login" system displays an error message says "<errorMessage>"
    Examples:
      | email        | password  | errorMessage               |
      #Locked Out credentials
      | locked_out_user | secret_sauce  | Epic sadface: Sorry, this user has been locked out.     |
      #Valid Email and invalid Password
      | mmmm@mmm.com | Aa123456  | Epic sadface: Username and password do not match any user in this service     |
      #Invalid Email and valid Password
      | mmm@mmm.com  | Aa123456@ | Epic sadface: Username and password do not match any user in this service     |
      #Valid Email and missing password
      | mmmm@mmm.com |           | Epic sadface: Password is required      |
      #Missed Email and Valid password
      |              | Aa123456@ | Epic sadface: Username is required |

