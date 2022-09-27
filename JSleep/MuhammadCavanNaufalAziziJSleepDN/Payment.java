package MuhammadCavanNaufalAziziJSleepDN;


public class Payment extends Invoice
{
    // instance variables - replace the example below with your own
    public String to, from;
    private int roomId;
    
    public Payment(int id, int buyerId, int renterId, String time, int roomId, String from, String to)
    {
        super(id, buyerId, renterId, time);
        this.roomId = roomId;
        this.from = from;
        this.to = to;
    }
    
    public Payment(int id, Account buyer, Renter renter, String time, int roomId, String from, String to)
    {
        super(id, buyer, renter, time);
        this.roomId = roomId;
        this.from = from;
        this.to = to;
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
