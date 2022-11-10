package com.MuhammadCavanNaufalAziziJSleepDN.controller;

import com.MuhammadCavanNaufalAziziJSleepDN.Account;
import com.MuhammadCavanNaufalAziziJSleepDN.Voucher;
import com.MuhammadCavanNaufalAziziJSleepDN.dbjson.JsonAutowired;
import com.MuhammadCavanNaufalAziziJSleepDN.dbjson.JsonTable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/voucher")
public class VoucherController implements BasicGetController<Voucher>
{
    @JsonAutowired(filepath = "voucher.json", value = Voucher.class)
    public static JsonTable<Voucher> voucherTable;
    
    @Override
    public JsonTable<Voucher> getJsonTable() {
        return voucherTable;
    }

    @GetMapping("/{id}/canApply")
    public boolean isUsed(@PathVariable int id) {
        for (Voucher voucher : voucherTable) {
            if (voucher.id == id) {
                return voucher.isUsed;
            }
        }
        return false;
    }

    @GetMapping("/{id}/canApply")
    public boolean canApply
    ( 
        @PathVariable int id,
        @RequestParam int price
    )
    {
        for (Voucher voucher : voucherTable) {
            if (voucher.id == id && voucher.price <= price) {
                return true;
            }
        }
        return false;
    }

    @GetMapping("/getAvailable")
    public List<Voucher> getAvailable(@RequestParam int page, @RequestParam int pageSize) {
        List<Voucher> voucherList = new ArrayList<>();
        for (Voucher voucher : voucherTable) {
            if (!voucher.isUsed) {
                voucherList.add(voucher);
            }
        }
        return voucherList;
    }


}
