package com.MuhammadCavanNaufalAziziJSleepDN.controller;

import com.MuhammadCavanNaufalAziziJSleepDN.Account;
import com.MuhammadCavanNaufalAziziJSleepDN.Renter;
import com.MuhammadCavanNaufalAziziJSleepDN.dbjson.JsonAutowired;
import com.MuhammadCavanNaufalAziziJSleepDN.dbjson.JsonTable;
import  java.util.regex.*;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account>
{
    public static final String REGEX_EMAIL = "^\\w+@\\w+([\\.-]?\\w+)*.?\\w+$";
    public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
    public static final String REGEX_PATTERN_EMAIL = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$";
    public static final String REGEX_PATTERN_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";

    @JsonAutowired(value = Account.class, filepath = "src/json/account.json")
    public static JsonTable<Account> accountTable;

    @Override
    @GetMapping("/account")
    public JsonTable<Account> getJsonTable() {
        return accountTable;
    }

    @PostMapping("/register")
    public Account register
            (
                    @RequestParam String name,
                    @RequestParam String email,
                    @RequestParam String password
            )
    {
        return null;
    }
    @PostMapping("/login")
    public Account login
            ( @RequestParam String email,
              @RequestParam String password
            )
    {
        for (Account account : getJsonTable()) {
            if (account.email.equals(email) && account.password.equals(password)) {
                return account;
            }
        }
        return null;
    }


    @PostMapping("/{id}/registerRenter")
    public Renter registerRenter
            (
             @RequestParam String username,
             @RequestParam  String address,
             @RequestParam String phoneNumber,
             @PathVariable String id) {
        return null;

    }

    @PostMapping("/{id}/topUp")
    public boolean topUp (
            @RequestParam double balance,
            @PathVariable String id) {
        return false;

    }
}
