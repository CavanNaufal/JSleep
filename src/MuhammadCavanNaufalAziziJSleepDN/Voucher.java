package MuhammadCavanNaufalAziziJSleepDN;


public class Voucher extends Serializable
{
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
