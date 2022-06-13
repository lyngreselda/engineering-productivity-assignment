package com.api.model;

public class orderDetails
{
    private String orderid;

    private String orderdescription;

    private orderDates lastupdatedtime;

    private String orderstatus;

    private String specialorder;

    public String getOrderId()
    {
        return orderid;
    }

    public void setOrderId (String orderid)
    {
        this.orderid = orderid;
    }

    public String getOrderDescription()
    {
        return orderdescription;
    }

    public void setOrderDescription (String orderdescription)
    {
        this.orderdescription = orderdescription;
    }

    public String getorderstatus()
    {
        return orderstatus;
    }

    public void setorderstatus (String orderstatus)
    {
        this.orderstatus = orderstatus;
    }

    public orderDates getlastupdatedtime ()
    {
        return lastupdatedtime;
    }

    public void setlastupdatedtime (orderDates lastupdatedtime)
    {
        this.lastupdatedtime = lastupdatedtime;
    }

    public String getSpecialOrder ()
    {
        return specialorder;
    }

    public void setSpecialOrder (String specialorder)
    {
        this.specialorder = specialorder;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [orderid = "+orderid+", orderdescription = "+orderdescription+", lastupdatedtime = "+lastupdatedtime+", specialorder = "+specialorder+"]";
    }
}