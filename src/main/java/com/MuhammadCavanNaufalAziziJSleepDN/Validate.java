package com.MuhammadCavanNaufalAziziJSleepDN;
import java.util.ArrayList;

/**
 * Write a description of class Validate here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Validate
{

    public static ArrayList filter (Price[] list, int value, boolean less)
    {
        ArrayList<Double> output = new ArrayList<>();
        for (Price price : list)
        {
            if (less == true)
            {
                if (price.price <= value)
                {
                    output.add(price.price);                    
                }
            }
            else if (less == false)
            {
                if (price.price > value)
                {
                    output.add(price.price);
                }
            }
        }
        return output;
    }
}
