package com.api.model;

public class order
{
    private orderDetails order;

    private String orderid;

    public orderDetails getorder ()
    {
        return order;
    }

    public void setorder (orderDetails order)
    {
        this.order = order;
    }

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
        return "ClassPojo [order = "+order+", orderid = "+orderid+"]";
    }
}