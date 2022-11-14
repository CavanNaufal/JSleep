package com.MuhammadCavanNaufalAziziJSleepDN;

import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Payment extends Invoice
{
    public Date to;
    public Date from;
    private int roomId;

    public Payment(int id, int buyerId, int renterId, int roomId, Date from, Date to)
    {
        super(buyerId, renterId);
        this.roomId = roomId;
        this.from = from;
        this.to = to;
    }

    public Payment(int id, Account buyer, Renter renter, int roomId, Date from, Date to)
    {
        super(buyer, renter);
        this.roomId = roomId;
        this.from = from;
        this.to = to;
    }

    public int getRoomId()
    {
        return this.roomId;
    }

    public static boolean makeBooking(Date from, Date to, Room room)
    {
        if(availability(from, to, room)){
            Calendar start = Calendar.getInstance();
            start.setTime(from);
            Calendar end = Calendar.getInstance();
            end.setTime(to);
            for (Date date = start.getTime(); start.before(end); start.add(Calendar.DATE, 1), date = start.getTime()) {
                room.booked.add(date);
            }
            return true;
        }
        return false;
    }

    public static boolean availability (Date from, Date to, Room room)
    {
        Calendar start = Calendar.getInstance();
        start.setTime(from);
        Calendar end = Calendar.getInstance();
        end.setTime(to);
        if(start.after(end) || start.equals(end)){
            return false;
        }
        for (Date date = start.getTime(); start.before(end); start.add(Calendar.DATE, 1), date = start.getTime()) {
            if(room.booked.contains(date)){
                return false;
            }
        }
        return true;
    }

    public String print()
    {
        return "\nRoom Id: " + this.roomId + "\nFrom: " + this.from + "\nTo: " + this.to;
    }

}