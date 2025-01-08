@tag
Feature: Error Validation Test
  I want to use this template for my feature file

  @ErrorValidation
  Scenario Outline: Title of your scenario outline
    Given I landed on Ecommers page
    When logged in with username <name> and password <password>
    Then "Incorrect email or password." messaged is displayed

    Examples: 
      | name                    | password     | 
      | nehakumari1997@gmail.com| Aashu@12345  | 
