package com.MuhammadCavanNaufalAziziJSleepDN;

import java.util.List;

import com.MuhammadCavanNaufalAziziJSleepDN.dbjson.JsonDBEngine;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;


/**
 * JSleep is a class that contains static methods for filtering a list of rooms by city, price, and account ID.
 * @author (Muhammad Cavan Naufal Azizi)
 * @version (a version number or a date)
 */

@SpringBootApplication
public class JSleep {
    public static void main(String[] args) {

        JsonDBEngine.Run(JSleep.class);
        SpringApplication.run(JSleep.class, args);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> JsonDBEngine.join()));
    }

    public static List<Room> filterByCity(List<Room> list, String city, int page, int pageSize) {
        return Algorithm.Paginate(list, page, pageSize, room -> room.city.toString().toLowerCase().contains(city.toLowerCase()));
    }
    public static List<Room> filterByPrice(List<Room> list, double minPrice, double maxPrice){
        if (maxPrice == 0) {
            return Algorithm.<Room>collect(list, room -> (room.price.price >= minPrice));
        }
        return Algorithm.<Room>collect(list, room -> (room.price.price >= minPrice) && (room.price.price <= maxPrice));
    }
    public static List<Room> filterByAccountId(List<Room> list, int accountId, int page, int pageSize){
        return Algorithm.Paginate(list, page,pageSize,room -> room.accountId == accountId);
    }
}

