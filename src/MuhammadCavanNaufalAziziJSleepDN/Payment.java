package MuhammadCavanNaufalAziziJSleepDN;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Payment extends Invoice
{
    // instance variables - replace the example below with your own
    public Date to, from;
    private int roomId;
    
    public Payment(int buyerId, int renterId, int roomId, Date from, Date to)
    {
        super(buyerId, renterId);
        this.roomId = roomId;
        this.from = from;
        this.to = to;
    }
    
    public Payment(Account buyer, Renter renter, int roomId, Date from, Date to)
    {
        super(buyer, renter);
        this.roomId = roomId;
        this.from = from;
        this.to = to;
    }
    
    public static boolean makeBooking(Date from, Date to, Room room)
    {
        Calendar tempDate = Calendar.getInstance();
        if(availability(from, to, room))
        {
            while(from.before(to))
            {
                room.booked.add(from);
                tempDate.setTime(from);
                tempDate.add(Calendar.DATE, 1);
                from = tempDate.getTime();
            }
            return true;
        }
        return false;
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
        if(from.compareTo(to) > 0 || from.equals(to))
        {
            return false;
        }

        for(Date i : room.booked)
        {
            if(from.equals(i))
            {
                return false;
            }
            else if (from.before(i))
            {
                if(from.before(i) && to.after(i))
                {
                    return false;
                }
            }
        }
        return true;
    }
}
