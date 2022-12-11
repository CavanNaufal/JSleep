package com.MuhammadCavanNaufalAziziJSleepDN;
import java.util.ArrayList;

/**
 * The Validate class provides a method for filtering a list of prices based on a specified value.
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
