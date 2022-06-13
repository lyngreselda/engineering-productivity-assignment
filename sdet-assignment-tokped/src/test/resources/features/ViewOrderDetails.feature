@bookerAPI @vieworder
Feature: To view the restful-booker order details

  @viewAllorderIDs
  Scenario: To view all the order IDs
    Given user has access to endpoint "/processOrder"
    When user makes a request to view order IDs
    Then user should get the response code 200
    And user should see all the order IDs

  @vieworderDetails
  Scenario: To view order details
    Given user has access to endpoint "/processOrder"
    When user makes a request to view order IDs
    And user makes a request to view details of a order ID
    Then user should get the response code 200
    And user validates the response with JSON schema "orderDetailsSchema.json"

  @healthCheck
  Scenario: To confirm whether the API is up and running
    Given user has access to endpoint "/ping"
    When user makes a request to check the health of order service
    Then user should get the response code 201
