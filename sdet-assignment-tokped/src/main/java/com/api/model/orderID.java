package com.api.model;

public class orderID {
	private String orderid;

	public String getorderid ()
	{
		return orderid;
	}

	public void setorderid (String orderid)
	{
		this.orderid = orderid;
	}

	@Override
	public String toString()
	{
		return "ClassPojo [orderid = "+orderid+"]";
	}
}
