@cartCheckout
Feature: User do Cart Checkout

  Scenario Outline: User try make an order and cart checkout
    Given A user in the home page
    When  user enter name and password in fields "<email>" "<password>"
    And   click on the login button
    Then  I'm in the home page
    And   click on the home page button
    When  Select "Faded Short Sleeve T-shirts" from the displayed products
    And   click on the add to cart button
    And   proceed to check out with "There is 1 item in your cart."
    And   proceed with a comment in the address "Please call me when arrive"
    And   proceed with the shipping cost with agree on the terms of service
    And   the quantity i have selected is "1"
    And   the unit i have selected is "Faded Short Sleeve T-shirts"
    And   select the payment way is "BANK-WIRE PAYMENT."
    And   click on the "I confirm my order" button
    Then  the order has been created successfully with message "Your order on My Store is complete."
    Examples:
      | email        | password  |
      | mmmm@mmm.com | Aa123456@ |

