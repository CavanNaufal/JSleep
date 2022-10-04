package MuhammadCavanNaufalAziziJSleepDN;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Payment extends Invoice
{
    // instance variables - replace the example below with your own
    public Calendar to, from;
    private int roomId;
    
    public Payment(int id, int buyerId, int renterId, int roomId)
    {
        super(id, buyerId, renterId);
        this.roomId = roomId;
        this.from = Calendar.getInstance();
        this.to = Calendar.getInstance();
        this.to.add(Calendar.DATE, 2);
    }
    
    public Payment(int id, Account buyer, Renter renter, int roomId)
    {
        super(id, buyer, renter);
        this.roomId = roomId;
        this.from = Calendar.getInstance();
        this.to = Calendar.getInstance();
        this.to.add(Calendar.DATE, 2);
    }
    
    public String getDuration()
    {
        SimpleDateFormat SDFormat = new SimpleDateFormat("dd MMMM yyyy");
        return SDFormat.format(from.getTime()) + " - " + SDFormat.format(to.getTime());
    }
    
    public String getTime()
    {
        return new SimpleDateFormat("'Formatted Date = 'dd MMMM yyyy").format(time.getTime());
    }

    public String print()
    {
        return "Room ID : " + roomId + "\nFrom : " + from + "\nTo : " + to;
    }
    
    public int getRoomId()
    {
        return roomId;
    }
    

}
