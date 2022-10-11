package MuhammadCavanNaufalAziziJSleepDN;


public class Renter extends Serializable
{
    // instance variables - replace the example below with your own
    public int phoneNumber = 0;
    public String address = "";
    public String username;

    public Renter(String username)
    {
        super();
        this.username = username;
    }
    
    public Renter(String username, String address)
    {
        super();
        this.username = username;
        this.address = address;
    }
    
    public Renter(String username, int phoneNumber)
    {
        super();
        this.username = username;
        this.phoneNumber = phoneNumber;
    }
    
    public Renter(String username, int phoneNumber, String address)
    {
        super();
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

}
