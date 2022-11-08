package com.MuhammadCavanNaufalAziziJSleepDN.controller;

import com.MuhammadCavanNaufalAziziJSleepDN.dbjson.Serializable;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.MuhammadCavanNaufalAziziJSleepDN.Algorithm;
import  com.MuhammadCavanNaufalAziziJSleepDN.dbjson.JsonTable;
import com.MuhammadCavanNaufalAziziJSleepDN.dbjson.Serializable;
import com.MuhammadCavanNaufalAziziJSleepDN.Algorithm;
import static com.MuhammadCavanNaufalAziziJSleepDN.Algorithm.Paginate;

@RestController
@RequestMapping("/account")
public interface BasicGetController <T extends Serializable> {
    @GetMapping("/person")
    public default List<T> getPage(
            @RequestParam int page,
            @RequestParam int pageSize
    ) {
        return Algorithm.<T>Paginate(getJsonTable(), page, pageSize, pred -> true);
    }

    @GetMapping("/person/{id}")
    public default T getById(
            @PathVariable int id
    ) {
        //Request Method GET will return object T with id
        return (T) Algorithm.<T>find(getJsonTable(), pred -> pred.id == id);
    }

    //Method getPage and getById will refer to collection from getJsonTable() method and use Algorithm to get the data
    public abstract JsonTable<T> getJsonTable();
}

