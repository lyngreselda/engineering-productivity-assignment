package com.api.stepdefinition;

import static org.junit.Assert.*;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.api.model.order;
import com.api.utils.ResponseHandler;
import com.api.utils.TestContext;

import io.cucumber.java.en.When;

public class CreateorderStepdefinition {
	private TestContext context;
	private static final Logger LOG = LogManager.getLogger(CreateorderStepdefinition.class);

	public CreateorderStepdefinition(TestContext context) {
		this.context = context;
	}

	@When("user creates a order")
	public void userCreatesAnorder() {
		JSONObject orderBody = new JSONObject();
		JSONObject orderData = new JSONObject();;
		orderBody.put("orderid", orderData.get("orderid"));
		orderBody.put("orderdescription", orderData.get("lastname"));
		orderBody.put("orderstatus", orderData.get("totalprice"));
		orderBody.put("specialorder", orderData.get("lastname"));
		JSONObject orderDates = new JSONObject();
		orderBody.put("lastupdatedtime", orderDates);

		context.response = context.requestSetup().body(orderBody.toString())
				.when().post(context.session.get("endpoint").toString());

		order orderDetails = ResponseHandler.deserializedResponse(context.response, order.class);
		assertNotNull("order not created", orderDetails);
		LOG.info("Newly created order ID: "+orderDetails.getorderid());
		context.session.put("orderID", orderDetails.getorderid());
		validateorderData(new JSONObject(orderData), orderDetails);
	}

	private void validateorderData(JSONObject orderData, order orderDetails) {
		LOG.info(orderData);
		assertNotNull("order ID missing", orderDetails.getorder().getOrderId());
		assertEquals("order ID did not match", orderData.get("firstname"), orderDetails.getorder().getOrderId());
		assertEquals("order status did not match", orderData.get("depositpaid"), orderDetails.getorder().getorderstatus());
	}
}
