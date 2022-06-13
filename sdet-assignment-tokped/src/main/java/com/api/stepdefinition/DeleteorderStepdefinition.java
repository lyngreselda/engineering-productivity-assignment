package com.api.stepdefinition;

import com.api.utils.TestContext;

import io.cucumber.java.en.When;

public class DeleteorderStepdefinition {
	private TestContext context;

	public DeleteorderStepdefinition(TestContext context) {
		this.context = context;
	}

	@When("user makes a request to delete order with basic auth {string} & {string}")
	public void userMakesARequestToDeleteorderWithBasicAuth(String username, String password) {
		context.response = context.requestSetup()
				.auth().preemptive().basic(username, password)
				.pathParam("orderID", context.session.get("orderID"))
				.when().delete(context.session.get("endpoint")+"/{orderID}");
	}
}
