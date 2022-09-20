package MuhammadCavanNaufalAziziJSleepDN;

public class Rating
{
    // instance variables - replace the example below with your own
    private long total, count;
    /**
     * Constructor for objects of class Rating
     */
    public Rating()
    {
        // initialise instance variables
        total = 0;
        count = 0;
    }


    public void insert(int rating)
    {
        // put your code here
        total += rating;
        count++;
    }
    
    public long getCount()
    {
        // put your code here
        return count;
    }
    
    public long getTotal()
    {
        // put your code here
        return total;
    }
    
    public double getAverage()
    {
        // put your code here
        if (count == 0){
            return 0;
        }
        return total / count;
    }
}
