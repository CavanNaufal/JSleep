package MuhammadCavanNaufalAziziJSleepDN;
import java.sql.Date;
import java.util.ArrayList;

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
        ArrayList<Room> RoomSerialized = new ArrayList<Room>();

        for(int i = 0; i < 5; i++){
            RoomSerialized.add(i, JSleep.createRoom());
            System.out.println(RoomSerialized.get(i).toString());
        }
//        Room RoomA = JSleep.createRoom();
//        Room RoomB = JSleep.createRoom();
//
//        System.out.println("Membuat booking dari tanggal 15 hingga 18");
//        Date start = Date.valueOf("2022-8-15");
//        Date end = Date.valueOf("2022-8-20");
//        System.out.println(Payment.makeBooking(start, end, RoomA));
//
//        System.out.println("Membuat booking dari tanggal 15 hingga 18");
//        Date start2 = Date.valueOf("2022-8-19");
//        Date end2 = Date.valueOf("2022-8-23");
//        System.out.println(Payment.makeBooking(start2, end2, RoomA));
//
//        System.out.println("Membuat booking dari tanggal 15 hingga 18 untuk kamar berbeda");
//        Date start3 = Date.valueOf("2022-8-18");
//        Date end3 = Date.valueOf("2022-8-20");
//        System.out.println(Payment.makeBooking(start3, end3, RoomB));
//
//        //Soal Bonus
//        System.out.println("Membuat booking dari tanggal 20 hingga 15");
//        Date start4 = Date.valueOf("2023-1-1");
//        Date end4 = Date.valueOf("2022-12-31");
//        System.out.println(Payment.makeBooking(start4, end4, RoomA));
    }

    public static Room createRoom()
    {
        Price price = new Price (100000, 0.5);
        Room room = new Room("Hotel", 30, price, Facility.AC, City.DEPOK, "Jalan Margonda Raya");
        return room;
    }
}

