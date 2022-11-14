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
public interface BasicGetController<T extends Serializable> {
    public abstract JsonTable<T> getJsonTable();
    @GetMapping("/page")
    public default List<T> getPage
            (
                    @RequestParam int page,
                    @RequestParam int pageSize
            ) {
        final JsonTable<T> table = getJsonTable();
        return Algorithm.Paginate(table, page, pageSize, o -> true);
    }

    @GetMapping("/{id}")
    public default T getById(@PathVariable int id) {
        return Algorithm.<T>find(getJsonTable(), e -> e.id == id);
    }
}

