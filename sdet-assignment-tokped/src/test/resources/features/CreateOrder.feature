@bookerAPI @createorder
Feature: To create a new order in restful-booker

  @createorderData
  Scenario Outline: To create new order
    Given user has access to endpoint "/processOrder"
    When user creates a order
    Then user should get the response code 200
    And user validates the response with JSON schema "createorderSchema.json"