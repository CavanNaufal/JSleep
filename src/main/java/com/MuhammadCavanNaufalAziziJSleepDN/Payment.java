package com.MuhammadCavanNaufalAziziJSleepDN;

import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;


/**
 * The `Payment` class extends the `Invoice` class and represents a payment for a room reservation.

 * It has three constructors:
 *  - `Payment(int buyerId, int renterId, int roomId, Date from, Date to)`: creates a new `Payment` object with the given buyer and renter IDs, room ID, and dates for the reservation.
 *  - `Payment(Account buyer, Renter renter, int roomId, Date from, Date to)`: creates a new `Payment` object with the given buyer and renter accounts, room ID, and dates for the reservation.
 *  - `Payment(int id, int buyerId, int renterId, int roomId, Date dateFrom, Date dateTo)`: creates a new `Payment` object with the given ID, buyer and renter IDs, room ID, and dates for the reservation.

 * It also has two static methods for checking the availability of a room and making a booking:
 *  - `availability(Date from, Date to, Room room)`: returns `true` if the given room is available for the given dates, and `false` otherwise.
 *  - `makeBooking(Date from, Date to, Room room)`: attempts to make a booking for the given room for the given dates. Returns `true` if the booking was successful, and `false` otherwise.

 * Finally, it has two instance methods:
 *  - `print()`: returns a string representation of the `Payment` object.
 *  - `getRoomId()`: returns the ID of the room associated with this `Payment` object.
 */
public class Payment extends Invoice
{
    public Date to, from;
    private int roomId;
    public double totalPrice;


    public Payment(int buyerId, int renterId, int roomId, Date from, Date to)
    {
        super(buyerId, renterId);
        this.to = new Date(to.getTime());
        this.from = new Date(from.getTime());
        this.roomId = roomId;
    }

    public Payment(Account buyer, Renter renter, int roomId, Date from, Date to)
    {
        super(buyer, renter);
        this.to = new Date(to.getTime());
        this.from = new Date(from.getTime());
        this.roomId = roomId;
    }

    public Payment(int id, int buyerId, int renterId, int roomId, Date dateFrom, Date dateTo) {
        super(buyerId, renterId);
        this.to = new Date(dateTo.getTime());
        this.from = new Date(dateFrom.getTime());
        this.roomId = roomId;
    }


    public static boolean availability(Date from, Date to, Room room)
    {
        if(from.after(to) ||to.before(from)||from.equals(to))
        {
            return false;
        }
        for(Date i: room.booked)
        {
            if (from.equals(i)){
                return false;
            }
            else if(from.before(i) && to.after(i))
            {
                return false;
            }
        }
        return true;
    }

    public static boolean makeBooking(Date from, Date to, Room room)
    {
        if(availability(from,to,room))
        {
            while(from.before(to))
            {
                room.booked.add(from);
                Calendar c = Calendar.getInstance();
                c.setTime(from);
                c.add(Calendar.DATE,1);
                from = c.getTime();
            }
            return true;
        }
        else
        {
            return false;
        }

    }

    public String print()
    {
        return "Room ID: " + roomId + "\nFrom: " + from + "\nTo: " + to;
    }

    public int getRoomId()
    {
        return roomId;
    }
}