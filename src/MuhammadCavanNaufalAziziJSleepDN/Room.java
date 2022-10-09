package MuhammadCavanNaufalAziziJSleepDN;
import java.util.ArrayList;
import java.util.Date;

public class Room extends Serializable implements FileParser
{
    // instance variables - replace the example below with your own
    public int size;
    public String name, address;
    public Facility facility;
    public Price price;
    public BedType bedType;
    public City city;
    public ArrayList<Date> booked = new ArrayList<>();
    
    public Room (int id, String name, int size, Price price, Facility facility, City city, String address)
    {
        super(id);
        this.name = name;
        this.size = size;
        this.price = price;
        this.facility = facility;
        this.city = city;
        this.address = address;
        this.bedType = BedType.SINGLE;
    }
    
    public String toString()
    {
        return "**** Room ****\n" +"ID Room : " + id +
        "\nName Room : " + name + 
        "\nSize : " + size + 
        "\n" + price + 
        "\nFacility : " + facility + 
        "\nCity : " + city + 
        "\nAddress : " + address + "\n";
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
