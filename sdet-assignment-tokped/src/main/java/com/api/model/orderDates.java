package com.api.model;

public class orderDates {

    private String lastupdatedtime;

    public String getlastupdatedtime ()
    {
        return lastupdatedtime;
    }

    public void setlastupdatedtime (String lastupdatedtime)
    {
        this.lastupdatedtime = lastupdatedtime;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [lastupdatedtime = "+lastupdatedtime+"]";
    }
}