package com.api.stepdefinition;

import static org.junit.Assert.*;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.api.model.orderID;
import com.api.utils.ResponseHandler;
import com.api.utils.TestContext;

import io.cucumber.java.en.*;
import io.restassured.module.jsv.JsonSchemaValidator;

public class VieworderDetailsStepdefinition {
	private TestContext context;
	private static final Logger LOG = LogManager.getLogger(VieworderDetailsStepdefinition.class);
	
	public VieworderDetailsStepdefinition(TestContext context) {
		this.context = context;
	}

	@Given("user has access to endpoint {string}")
	public void userHasAccessToEndpoint(String endpoint) {		
		context.session.put("endpoint", endpoint);
	}

	@When("user makes a request to view order IDs")
	public void userMakesARequestToVieworderIDs() {
		context.response = context.requestSetup().when().get(context.session.get("endpoint").toString());
		int orderID = context.response.getBody().jsonPath().getInt("[0].orderid");
		LOG.info("order ID: "+orderID);
		assertNotNull("order ID not found!", orderID);
		context.session.put("orderID", orderID);
	}

	@Then("user should get the response code {int}")
	public void userShpuldGetTheResponseCode(Integer statusCode) {
		assertEquals(Long.valueOf(statusCode), Long.valueOf(context.response.getStatusCode()));
	}

	@Then("user should see all the order IDs")
	public void userShouldSeeAllTheorderIDS() {		
		orderID[] orderIDs = ResponseHandler.deserializedResponse(context.response, orderID[].class);
		assertNotNull("order ID not found!!", orderIDs);		
	}

	@Then("user validates the response with JSON schema {string}")
	public void userValidatesResponseWithJSONSchema(String schemaFileName) {
		context.response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/"+schemaFileName));
		LOG.info("Successfully Validated schema from "+schemaFileName);
	}
}
