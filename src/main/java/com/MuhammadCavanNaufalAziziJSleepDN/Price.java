package com.MuhammadCavanNaufalAziziJSleepDN;

public class Price
{
    // instance variables - replace the example below with your own
    public double price;
    public double discount;
    
    /**
     * Constructor for objects of class Price
     */
    public Price(double price)
    {
        // initialise instance variables
        this.price = price;
        this.discount = 0;
    }
    
    public Price(double price, double discount)
    {
        // initialise instance variables
        this.price = price;
        this.discount = discount;
    }
    
    public String toString()
    {
        return "Price : " + price + "\nDiscount : " + discount;
    }

}
