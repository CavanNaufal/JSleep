package MuhammadCavanNaufalAziziJSleepDN;


public class Renter extends Serializable
{
    // instance variables - replace the example below with your own
    public String phoneNumber;
    public String address;
    public String username;

    public static final String REGEX_NAME = "^[A-Z][a-zA-Z0-9_]{4,20}$";
    public static final String REGEX_PHONE = "^[0-9]{9,12}$";
    
    public Renter(String username, String phoneNumber, String address)
    {
        super();
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public boolean validate()
    {
        return username.matches(REGEX_NAME) && phoneNumber.matches(REGEX_PHONE);
    }
}
