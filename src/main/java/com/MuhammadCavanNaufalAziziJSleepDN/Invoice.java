package com.MuhammadCavanNaufalAziziJSleepDN;
import java.util.Calendar;
import java.util.Date;

public class Invoice extends Serializable
{
    public enum RoomRating
    {
        NONE,
        BAD,
        NEUTRAL,
        GOOD
    }
    
    public enum PaymentStatus
    { 
        FAILED,
        WAITING,
        SUCCESS
    }
    
    // instance variables - replace the example below with your own
    public int buyerId, renterId;
    public Date time;
    public PaymentStatus status;
    public RoomRating rating;

    protected Invoice(int buyerId, int renterId)
    {
       super();
       this.buyerId = buyerId;
       this.renterId = renterId;
       this.time = new Date();
       this.rating = RoomRating.NONE;
       this.status = PaymentStatus.WAITING;
    }
    
    public Invoice(Account buyer, Renter renter)
    {
       super();
       this.buyerId = buyer.id;
       this.renterId = renter.id;
       this.time = new Date();
       this.rating = RoomRating.NONE;
       this.status = PaymentStatus.WAITING;
    }

    public String print()
    {
        return "Buyer ID : " + buyerId + "\nRenter ID : " + renterId + "\nTime : " + time;
    }
}
