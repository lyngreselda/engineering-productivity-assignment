package com.api.stepdefinition;

import static org.junit.Assert.assertNotNull;

import java.util.Map;

import org.json.JSONObject;

import com.api.model.orderDetails;
import com.api.utils.ResponseHandler;
import com.api.utils.TestContext;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;

public class UpdateorderStepdefinition {
	private TestContext context;
	
	public UpdateorderStepdefinition(TestContext context) {
		this.context = context;
	}

	@When("user updates the details of a order")
	public void userUpdatesAorder(DataTable dataTable) {
		Map<String,String> orderData = dataTable.asMaps().get(0);
		JSONObject orderBody = new JSONObject();
		orderBody.put("order_status", orderData.get("order_status"));
		orderBody.put("last_updated_timestamp", orderData.get("last_updated_timestamp"));

		context.response = context.requestSetup()
				.header("Cookie", context.session.get("token").toString())
				.pathParam("orderID", context.session.get("orderID"))
				.body(orderBody.toString())
				.when().put(context.session.get("endpoint")+"/{orderID}");

		orderDetails orderDetails = ResponseHandler.deserializedResponse(context.response, orderDetails.class);
		assertNotNull("order not created", orderDetails);
	}
}
