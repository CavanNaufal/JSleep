package com.MuhammadCavanNaufalAziziJSleepDN;


import com.MuhammadCavanNaufalAziziJSleepDN.Price;
import com.MuhammadCavanNaufalAziziJSleepDN.Type;
import com.MuhammadCavanNaufalAziziJSleepDN.dbjson.Serializable;

/**
 * This class represents a voucher. It can be used to apply discounts or deductions to a price.
 * The voucher has a name, code, type, and a minimum value that it can be applied to. It also
 * tracks whether it has been used or not.
 */
public class Voucher extends Serializable
{
    public boolean isUsed;
    public int price;
    // instance variables - replace the example below with your own
    private boolean used;
    public double cut, minimum;
    public Type type;
    public String name;
    public int code;
    
    public Voucher(String name, int code, Type type, boolean used, double minimum, double cut)
    {
        // initialise instance variables
        super();
        this.name = name;
        this.code = code;
        this.type = type;
        this.used = false;
        this.minimum = minimum;
        this.cut = cut;
    }

    public boolean canApply(Price price)
    {
        if (price.price > this.minimum && this.used == false){
           return true; 
        }
        return false;
    }
       
    public double apply(Price price)
    {
        this.used = true;
        if(type == Type.DISCOUNT){
            if(this.cut > 100){
                this.cut = 100;
            }
            return price.price * (100 - this.cut) / 100;
        }else{
            if(this.cut > price.price){
                this.cut = price.price;
            }
            return price.price - this.cut;
        }
    }
    
    public boolean isUsed()
    {
        return this.used;
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
