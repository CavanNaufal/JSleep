package MuhammadCavanNaufalAziziJSleepDN;
import java.sql.Date;
/**
 * Write a description of class JSleep here.
 *
 * @author (Muhammad Cavan Naufal Azizi)
 * @version (a version number or a date)
 */

public class JSleep
{
    public static void main(String[] args)
    {
        Room RoomA = JSleep.createRoom();
        Room RoomB = JSleep.createRoom();
        
        System.out.println("Membuat booking dari tanggal 15 hingga 18");
        Date start = Date.valueOf("2022-8-15");
        Date end = Date.valueOf("2022-8-20");
        System.out.println(Payment.makeBooking(start, end, RoomA));
        
        System.out.println("Membuat booking dari tanggal 15 hingga 18");
        Date start2 = Date.valueOf("2022-8-18");
        Date end2 = Date.valueOf("2022-8-20");
        System.out.println(Payment.makeBooking(start2, end2, RoomA));
        
        System.out.println("Membuat booking dari tanggal 15 hingga 18 untuk kamar berbeda");
        Date start3 = Date.valueOf("2022-8-18");
        Date end3 = Date.valueOf("2022-8-20");
        System.out.println(Payment.makeBooking(start3, end3, RoomB));
        
        //Soal Bonus
        System.out.println("Membuat booking dari tanggal 20 hingga 15");
        Date start4 = Date.valueOf("2022-8-20");
        Date end4 = Date.valueOf("2022-8-15");
        System.out.println(Payment.makeBooking(start4, end4, RoomA));    
    }
    
    public static Room createRoom(){
        Price price = new Price (100000, 5);
        Room room = new Room(1, "hotel", 2, price, Facility.AC, City.DEPOK, "Jaya");
        return room;
    } 
}

