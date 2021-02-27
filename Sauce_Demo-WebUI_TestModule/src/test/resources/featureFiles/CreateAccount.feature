@registration
Feature: Registration

  Scenario Outline: User try to create an account with valid data
    Given A user in the home page
    And   click on the signIn button
    And   Redirected to the login page
    When  Enter email valid "<email>"
    And   Click on the Create An Account button
    And   Redirected to continue registration page
    And   Fill all the required fields of personal information section "<gender>" , "<firstName>", "<lastName>" ,"<password>" and data of birth is "<day>", "<month>" and "<year>" and "<newsletter>" and "<option>"
    And   Fill all the required fields of the your Address section "<address>", "<city>", "<state>", "<zipCode>", "<Country>", "<mobilePhone>" and "<alias>"
    And   click on Register button
    Then  the account has been created successfully
    Examples:
      | email          | gender | firstName | lastName | password | day | month | year | newsletter | option | address   | city  | state   | zipCode | Country       | mobilePhone | alias |
      | FakerGenerated | male   | Test      | Test     | 123456   | 27  | 5     | 2010 | 1          | 0      | CairoTest | Cairo | Alabama | 12345   | United States | 0112345698  | Test  |

  Scenario Outline: Verify user can't register with registered email
    Given A user in the home page
    And   click on the signIn button
    And   Redirected to the login page
    When  Enter email valid "<email>"
    And   Click on the Create An Account button
    Then  In "create account" system displays an error message says "<errorMessage>"
    Examples:
      | email        | errorMessage                                                                                                         |
      | mmmm@mmm.com | An account using this email address has already been registered. Please enter a valid password or request a new one. |

  Scenario Outline: Verify user can't register with invalid data
    Given A user in the home page
    And   click on the signIn button
    And   Redirected to the login page
    When  Enter email valid "<email>"
    And   Click on the Create An Account button
    And   Redirected to continue registration page
    And   Fill all the required fields of personal information section "<gender>" , "<firstName>", "<lastName>" ,"<password>" and data of birth is "<day>", "<month>" and "<year>" and "<newsletter>" and "<option>"
    And   Fill all the required fields of the your Address section "<address>", "<city>", "<state>", "<zipCode>", "<Country>", "<mobilePhone>" and "<alias>"
    And   click on Register button
    Then system will deisolay message says "<errorMessage>"
    Examples:
      | email          | gender | firstName | lastName | password | day | month | year | newsletter | option | address   | city  | state   | zipCode | Country       | mobilePhone | alias | errorMessage                                 |
      | FakerGenerated | male   | 12313131  | Test     | 123456   | 27  | 5     | 2010 | 1          | 0      | CairoTest | Cairo | Alabama | 12345   | United States | 0112345698  | Test  | firstname is invalid.                        |
      | FakerGenerated | male   |           | Test     | 123456   | 27  | 5     | 2010 | 1          | 0      | CairoTest | Cairo | Alabama | 12345   | United States | 0112345698  | Test  | firstname is required.                       |
      | FakerGenerated | male   | test      |          | 123456   | 27  | 5     | 2010 | 1          | 0      | CairoTest | Cairo | Alabama | 12345   | United States | 0112345698  | Test  | lastname is required.                        |
      | FakerGenerated | male   |           | 1235464  | 123456   | 27  | 5     | 2010 | 1          | 0      | CairoTest | Cairo | Alabama | 12345   | United States | 0112345698  | Test  | lastname is invalid.                         |
      | FakerGenerated | male   | test      | test     | 123456   | 27  | 5     | 2010 | 1          | 0      |           | Cairo | Alabama | 12345   | United States | 0112345698  | Test  | address1 is required.                        |
      | FakerGenerated | male   | test      | test     | 123456   | 27  | 5     | 2010 | 1          | 0      | CairoTest |       | Alabama | 12345   | United States | 0112345698  | Test  | city is required.                            |
      | FakerGenerated | male   | test      | test     | 123456   | 27  | 5     | 2010 | 1          | 0      | CairoTest | Cairo | Alabama | 12345   | United States |             | Test  | You must register at least one phone number. |
      | FakerGenerated | male   | test      | test     |          | 27  | 5     | 2010 | 1          | 0      | CairoTest | Cairo | Alabama | 12345   | United States | 0112345698  | Test  | password is required.                        |



