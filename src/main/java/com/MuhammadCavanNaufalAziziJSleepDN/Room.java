package com.MuhammadCavanNaufalAziziJSleepDN;
import com.MuhammadCavanNaufalAziziJSleepDN.*;
import com.MuhammadCavanNaufalAziziJSleepDN.dbjson.Serializable;

import java.util.ArrayList;
import java.util.Date;

public class Room extends Serializable
{
    // instance variables - replace the example below with your own
    public int size, accountId;
    public String name, address;
    public Facility facility;
    public Price price;
    public BedType bedType;
    public City city;
    public ArrayList<Date> booked = new ArrayList<>();
    
    public Room (int accountId, String name, int size, Price price, Facility facility, City city, String address)
    {
        super();
        this.name = name;
        this.size = size;
        this.accountId = accountId;
        this.price = price;
        this.facility = facility;
        this.city = city;
        this.address = address;
        this.bedType = BedType.SINGLE;
    }
    
    public String toString()
    {
        return  "**** Room ****" +
                "\nName Room : " + name +
                "\nBed Type : " + bedType +
                "\nSize : " + size +
                "\n" + price +
                "\nFacility : " + facility +
                "\nCity : " + city +
                "\nAddress : " + address +
                "\nId : " + id +
                "\n";
    }
    
    public Object write()
    {
        return null;
    }
    
    public boolean read(String content)
    {
        return false;
    }
}
