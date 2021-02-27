@login
Feature: Home Page

  Scenario Outline: Add products from landing page
    Given A user in the home page
    When user enter name and password in fields "<email>" "<password>"
    And click on the login button
    And click on the add to cart button
    Then   Product shall be added to the cart
    Examples:
      | email        | password  |
      | standard_user| secret_sauce |



  Scenario Outline: Remove product from landing page
    Given A user in the home page
    When user enter name and password in fields "<email>" "<password>"
    And click on the login button
    And click on the add to cart button
    And Product shall be added to the cart
    And click on the Remove button
    Then   Product shall be removed from the cart
    Examples:
      | email        | password  |
      | standard_user| secret_sauce |
