package com.MuhammadCavanNaufalAziziJSleepDN.controller;

import com.MuhammadCavanNaufalAziziJSleepDN.Account;
import com.MuhammadCavanNaufalAziziJSleepDN.Algorithm;
import com.MuhammadCavanNaufalAziziJSleepDN.Price;
import com.MuhammadCavanNaufalAziziJSleepDN.Voucher;
import com.MuhammadCavanNaufalAziziJSleepDN.dbjson.JsonAutowired;
import com.MuhammadCavanNaufalAziziJSleepDN.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * This class implements the BasicGetController interface and provides methods
 * to check the availability and validity of vouchers.
 *
 * @see BasicGetController
 * @see Voucher
 */

@RestController
@RequestMapping("/voucher")
public class VoucherController implements BasicGetController<Voucher> {
    @JsonAutowired(value = Voucher.class, filepath = "src/json/voucher.json")
    public static JsonTable<Voucher> voucherTable;
    @Override
    public JsonTable<Voucher> getJsonTable() {
        return voucherTable;
    }

    /**
     * Checks if a voucher with the given ID and price has been used.
     *
     * @param id the ID of the voucher
     * @param price the price of the voucher
     * @return true if the voucher has been used, false otherwise
     */
    @GetMapping ("/{id}/isUsed")
    boolean isUsed (@PathVariable int id, @RequestParam double price){
        Voucher voucher = Algorithm.<Voucher>find(voucherTable, pred -> pred.id == id);
        return voucher.isUsed();
    }

    /**
     * Returns a paginated list of available vouchers.
     *
     * @param page the page number to retrieve
     * @param size the number of vouchers to retrieve per page
     * @return a paginated list of available vouchers
     */
    @GetMapping ("/getAvailable ")
    List<Voucher> getAvailable (@RequestParam int page, @RequestParam int size){
        return Algorithm.<Voucher>Paginate(voucherTable, page, size, pred -> !pred.isUsed());
    }

    /**
     * Determines if a voucher can be applied to a given price.
     *
     * @param id The ID of the voucher to check.
     * @param price The price to check against.
     * @return `true` if the voucher can be applied to the given price, `false` otherwise.
     */
    @GetMapping ("/{id}/canApply ")
    boolean canApply (
            @PathVariable int id,
            @RequestParam double price
    ){
        Voucher voucher = Algorithm.<Voucher>find(voucherTable, pred -> pred.id == id);
        if(voucher == null){
            return false;
        }
        else{
            return voucher.canApply(new Price(price));
        }
    }
}