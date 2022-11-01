package MuhammadCavanNaufalAziziJSleepDN;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.*;

/**
 * Write a description of class JSleep here.
 *
 * @author (Muhammad Cavan Naufal Azizi)
 * @version (a version number or a date)
 */

public class JSleep
{
    class Country
    {
        public String name;
        public int population;
        public List<String> listOfStates;
    }
    public static void main(String[] args)
    {
        Renter testRegex = new Renter("Netlab_", "081234567890", "Jl. Margonda Raya");
        Renter testRegexFail = new Renter("netlab", "081", "Jalan");
        System.out.println(testRegex.validate());
        System.out.println(testRegexFail.validate());

        try
        {
            String filepath = "D:\\Universitas Indonesia\\Semester 3\\OOP\\Praktikum\\JSleep\\src\\json\\randomRoomList.json";

            JsonTable<Room> tableRoom = new JsonTable<>(Room.class, filepath);
            List<Room> filterTableRoom = filterByCity(tableRoom, "jakarta", 0, 5);
            filterTableRoom.forEach(room -> System.out.println(room.toString()));
        }
        catch (Throwable t)
        {
            t.printStackTrace();
        }
    }

    public static Room createRoom(){
        Price price = new Price (100000, 5);
        Room room = new Room(1, "hotel", 2, price, Facility.AC, City.DEPOK, "Jaya");
        return room;
    }

    public static List<Room> filterByCity(List<Room> list, String search, int page, int pageSize)
    {
        List<Room> result = new ArrayList<>();
        for (Room room : list)
        {
            if (room.city.name().toLowerCase().contains(search.toLowerCase()))
            {
                result.add(room);
            }
        }
        return result.subList(page * pageSize, Math.min((page + 1) * pageSize, result.size()));
    }

    public static List<Room> filterByPrice(List<Room> list, double minPrice, double maxPrice)
    {
        List<Room> resultByPrice = new ArrayList<>();
        for (Room room : list)
        {
            if (room.price.price >= minPrice && room.price.price <= maxPrice)
            {
                resultByPrice.add(room);
            }
        }
        return resultByPrice;
    }

    public static List<Room> filterByAccountId(List<Room> list, int accountId, int page, int pageSize)
    {
        List<Room> resultByAccountId = new ArrayList<>();
        int start = page * pageSize;
        int end = start + pageSize;
        for (int i = start; i < end; i++)
        {
            Room room = list.get(i);
            if (room.accountId == accountId)
            {
                resultByAccountId.add(room);
            }
        }
        return resultByAccountId;
    }
}

