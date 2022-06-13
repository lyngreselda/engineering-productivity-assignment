@bookerAPI @deleteorder
Feature: To delete a order in restful-booker

  Background: create an auth token
    Given user has access to endpoint "/auth"
    When user creates a auth token with credential "admin" & "password123"
    Then user should get the response code 200

  @deleteorderIDs
  Scenario: To delete a order
    Given user has access to endpoint "/order"
    And user makes a request to view order IDs
    When user makes a request to delete order with basic auth "admin" & "password123"
    Then user should get the response code 201
