package com.MuhammadCavanNaufalAziziJSleepDN.controller;

import com.MuhammadCavanNaufalAziziJSleepDN.Account;
import com.MuhammadCavanNaufalAziziJSleepDN.City;
import com.MuhammadCavanNaufalAziziJSleepDN.Facility;
import com.MuhammadCavanNaufalAziziJSleepDN.Room;
import com.MuhammadCavanNaufalAziziJSleepDN.dbjson.JsonAutowired;
import com.MuhammadCavanNaufalAziziJSleepDN.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/room")
public class RoomController implements BasicGetController<Room>
{
    @JsonAutowired(filepath = "room.json", value = Room.class)
    public static JsonTable<Room> roomTable;

    @GetMapping("/{id}/renter")
    public List<Room> getRoomByRenter
    (
        @PathVariable int id,
        @RequestParam int page,
        @RequestParam int pageSize
    )
    {
        List<Room> roomList = new ArrayList<>();
        for (Room room : roomTable) {
            if (room.renter.id == id) {
                roomList.add(room);
            }
        }
        return roomList;
    }

    @PostMapping("/create")
    public Room create
    (
        @RequestParam int accountId,
        @RequestParam String name,
        @RequestParam int size,
        @RequestParam int price,
        @RequestParam Facility facility,
        @RequestParam City city,
        @RequestParam String address 
    )
    {
        for (Account account : AccountController.accountTable) {
            if (account.id == accountId) {
                Room room = new Room(name, size, price, facility, city, address);
                room.renter = account.renter;
                return room;
            }
        }
        return null;
    }

    @Override
    public JsonTable<Room> getJsonTable() {
        return null;
    }
}
