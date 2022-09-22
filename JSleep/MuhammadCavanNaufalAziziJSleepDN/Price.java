package MuhammadCavanNaufalAziziJSleepDN;


public class Price
{
    // instance variables - replace the example below with your own
    public double price, rebate;
    public double discount;
    
    /**
     * Constructor for objects of class Price
     */
    public Price(double price)
    {
        // initialise instance variables
        this.price = price;
        this.discount = 0;
        this.rebate = 0;
    }
    
    public Price(double price, double discount)
    {
        // initialise instance variables
        this.price = price;
        this.discount = discount;
        this.rebate = 0;
    }
    
    /*
    public Price(double price, double rebate)
    {
        // initialise instance variables
        this.price = price;
        this.discount = discount;
        this.discount = 0;
    }


    private double getDiscountedPrice()
    {
        // put your code here
        double discount = this.discount;
        if (discount > 100.0){
            discount = 100.0;
        }else if (discount == 100){
            return 0.0;
        }
        return this.price - (this.price * discount / 100);
    }
    
    private double getRebatePrice()
    {
        // put your code here
        if (this.rebate > this.price){
            this.price = this.rebate;
            return this.price;
        }
        return this.price - this.rebate;
    }
    */
}
