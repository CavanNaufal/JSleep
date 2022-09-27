package MuhammadCavanNaufalAziziJSleepDN;


public class Room extends Serializable
{
    // instance variables - replace the example below with your own
    public int size;
    public String name;
    public Facility facility;
    public Price price;

    public Room (int id, String name, int size, Price price, Facility facility)
    {
        super(id);
        this.name = name;
        this.size = size;
        this.price = price;
        this.facility = facility;
    }
}