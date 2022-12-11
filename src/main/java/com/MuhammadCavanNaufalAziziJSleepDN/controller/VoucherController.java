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
    @GetMapping ("/{id}/isUsed")
    boolean isUsed (@PathVariable int id, @RequestParam double price){
        Voucher voucher = Algorithm.<Voucher>find(voucherTable, pred -> pred.id == id);
        return voucher.isUsed();
    }
    @GetMapping ("/getAvailable ")
    List<Voucher> getAvailable (@RequestParam int page, @RequestParam int size){
        return Algorithm.<Voucher>Paginate(voucherTable, page, size, pred -> !pred.isUsed());
    }
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