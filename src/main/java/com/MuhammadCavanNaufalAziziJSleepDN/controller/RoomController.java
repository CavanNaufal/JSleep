package com.MuhammadCavanNaufalAziziJSleepDN.controller;

import com.MuhammadCavanNaufalAziziJSleepDN.*;
import com.MuhammadCavanNaufalAziziJSleepDN.dbjson.JsonAutowired;
import com.MuhammadCavanNaufalAziziJSleepDN.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The `RoomController` class provides REST API endpoints for managing rooms.

 * It uses the `JsonAutowired` annotation to read a `Room` object from a JSON file,
 * and it implements the `BasicGetController` interface to provide a `getJsonTable` method.

 * The `index` method provides a basic message for the root URL of the API.

 * The `getRoomByRenter` method returns a paginated list of rooms that are rented by a specific renter,
 * as identified by their `accountId`.

 * The `create` method allows a renter to create a new room, provided they have a valid `accountId`
 * and have already registered as a renter.

 * The `getAllRoom` method returns a paginated list of all rooms in the system.
 */

@RestController
@RequestMapping("/room")
public class RoomController implements BasicGetController<Room>{
    @JsonAutowired(value = Room.class, filepath = "src/json/room.json")
    public static JsonTable<Room> roomTable;

    @GetMapping
    String index() {
        return "room page";
    }

    @Override
    public JsonTable<Room> getJsonTable() {
        return roomTable;
    }

    @GetMapping("/{id}/renter")
    List<Room> getRoomByRenter
            (
                    @PathVariable int id,
                    @RequestParam int page,
                    @RequestParam int pageSize
            )
    {
        return Algorithm.Paginate(getJsonTable(), page, pageSize, pred -> pred.accountId == id);
    }

    @PostMapping("/create")
    public Room create(
            @RequestParam int accountId,
            @RequestParam String name,
            @RequestParam int size,
            @RequestParam int price,
            @RequestParam ArrayList<Facility> facility,
            @RequestParam City city,
            @RequestParam String address,
            @RequestParam BedType bedType
    ){
        Account account = Algorithm.<Account>find(AccountController.accountTable, pred -> pred.id == accountId && pred.renter != null);
        if(account == null) return null;
        else{
            Room room = new Room(accountId, name, size, new Price(price), facility, city, address, bedType);
            roomTable.add(room);
            return room;
        }
    }

    @GetMapping("/getAllRoom")
    public List<Room> getAllRoom(@RequestParam int page, @RequestParam int pageSize){
        return Algorithm.<Room>Paginate(getJsonTable(), page, pageSize, pred -> true);
    }
}
