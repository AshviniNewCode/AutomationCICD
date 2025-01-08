@tag
Feature: Purchase the order from Ecommerce Website
  I want to use this template for my feature file
  
  Background: 
  Given I landed on Ecommers page

  @Regression
  Scenario Outline: Positive Test for submitting the order
    Given logged in with username <name> and password <password>
    When I add product <productName> to cart
    And Checkout <productName> and submit the Order
    Then "THANKYOU FOR THE ORDER." message is displayed on confirmationPage

    Examples: 
      | name                    | password     | productName    |
      | nehakumari1997@gmail.com| Aashu@123456 | ADIDAS ORIGINAL|

      

