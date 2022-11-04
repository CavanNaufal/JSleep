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
        try
        {
            String filepath = "D:\\Universitas Indonesia\\Semester 3\\OOP\\Praktikum\\JSleep\\src\\json\\account.json";

            JsonTable<Account> tableAccount = new JsonTable<>(Account.class, filepath);
            tableAccount.add(new Account("name", "email", "password"));
            tableAccount.writeJson();

            tableAccount = new JsonTable<>(Account.class, filepath);
            tableAccount.forEach(account -> System.out.println(account.toString()));
        }
        catch (Throwable t)
        {
            t.printStackTrace();
        }

        for(int i = 0; i < 10; i++)
        {
            ThreadingObject thread = new ThreadingObject("Thread " + i);
        }
    }

    public static Room createRoom(){
        Price price = new Price (100000, 5);
        return new Room(1, "hotel", 2, price, Facility.AC, City.DEPOK, "Jaya");
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
        List<Room> result = new ArrayList<>();
        for (Room room : list)
        {
            if (room.price.price >= minPrice && room.price.price <= maxPrice)
            {
                result.add(room);
            }
        }
        return result.subList(0, Math.min(5, result.size()));
    }

    public static List<Room> filterByAccountId(List<Room> list, int accountId, int page, int pageSize)
    {
        List<Room> result = new ArrayList<>();
        for (Room room : list)
        {
            if (room.accountId == accountId)
            {
                result.add(room);
            }
        }
        return result.subList(page * pageSize, Math.min((page + 1) * pageSize, result.size()));
    }
}

