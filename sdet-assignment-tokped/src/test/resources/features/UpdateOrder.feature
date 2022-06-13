@bookerAPI @updateorder
Feature: To update a order in restful-booker

  @updateorderData
  Scenario Outline: To update a order using cucumber Data
    Given user has access to endpoint "/processOrder"
    When user makes a request to view order IDs
    And user updates the details of a order
    Then user should get the response code 200
    And user validates the response with JSON schema "orderDetailsSchema.json"

  @partialUpdateorder
  Scenario: To partially update a order
    Given user has access to endpoint "/processOrder"
    When user makes a request to view order IDs
    And user makes a request to update order_status "Shipped" and last_updated_time 
    Then user should get the response code 200
    And user validates the response with JSON schema "orderDetailsSchema.json"