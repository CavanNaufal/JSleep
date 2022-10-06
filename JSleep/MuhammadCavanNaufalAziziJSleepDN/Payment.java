package MuhammadCavanNaufalAziziJSleepDN;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Payment extends Invoice
{
    // instance variables - replace the example below with your own
    public Date to, from;
    private int roomId;
    
    public Payment(int id, int buyerId, int renterId, int roomId, Date from, Date to)
    {
        super(id, buyerId, renterId);
        this.roomId = roomId;
        this.from = new Date();
        this.to = new Date();
    }
    
    public Payment(int id, Account buyer, Renter renter, int roomId, Date from, Date to)
    {
        super(id, buyer, renter);
        this.roomId = roomId;
        this.from = new Date();
        this.to = new Date();
    }
    
    public static boolean makeBooking(Date from, Date to, Room room)
    {
        if(availability(from, to, room))
        {
            room.booked.add(from);
            room.booked.add(to);
            return true;
        }
        else
        {
            return false;
        }
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
    
    public static boolean availability(Date from, Date to, Room room)
    {   
        if(room.booked.isEmpty())
        {
            return true;
        }
        else if(from.compareTo(to) > 0)
        {
            return false;
        }
        else
        {
            for(int i = 0; i < room.booked.size(); i++)
            {
                if(room.booked.get(i).compareTo(from) == 0 || room.booked.get(i).compareTo(to) == 0)
                {
                    return false;
                }
            }
            return true;
        }
    }

}
