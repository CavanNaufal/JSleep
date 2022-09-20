package MuhammadCavanNaufalAziziJSleepDN;


public class Price
{
    // instance variables - replace the example below with your own
    public double price, rebate;
    public int discount;
    
    /**
     * Constructor for objects of class Price
     */
    public Price(double price)
    {
        // initialise instance variables
        this.price = price;
        discount = 0;
        price = 0;
    }
    
    public Price(double price, int discount)
    {
        // initialise instance variables
        this.price = price;
        rebate = 0;
    }
    
    public Price(double price, double rebate)
    {
        // initialise instance variables
        this.price = price;
        discount = 0;
    }


    private double getDiscountedPrice()
    {
        // put your code here
        if (discount > 100){
            discount = 100;
        }else if (discount == 100){
            return 0;
        }
        return price - (price * discount / 100);
    }
    
    private double getRebatePrice()
    {
        // put your code here
        if (rebate > price){
            price = rebate;
            return price;
        }
        return price - rebate;
    }
}
