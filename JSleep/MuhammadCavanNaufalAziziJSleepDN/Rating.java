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
        this.total = 0;
        this.count = 0;
    }


    public void insert(int rating)
    {
        // put your code here
        this.total += rating;
        this.count++;
    }
    
    public long getCount()
    {
        // put your code here
        return this.count;
    }
    
    public long getTotal()
    {
        // put your code here
        return this.total;
    }
    
    public double getAverage()
    {
        // put your code here
        if (this.count == 0){
            return 0.0;
        }
        return this.total / this.count;
    }
}
