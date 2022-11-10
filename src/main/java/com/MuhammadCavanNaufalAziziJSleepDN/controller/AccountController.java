package com.MuhammadCavanNaufalAziziJSleepDN.controller;

import com.MuhammadCavanNaufalAziziJSleepDN.Account;
import com.MuhammadCavanNaufalAziziJSleepDN.Algorithm;
import com.MuhammadCavanNaufalAziziJSleepDN.Renter;
import com.MuhammadCavanNaufalAziziJSleepDN.Room;
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
    public static final Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);
	public static final Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);

    @JsonAutowired(filepath = "account.json", value = Account.class)
    public static JsonTable<Account> accountTable;

    @Override
    @GetMapping("/account")
    public JsonTable<Account> getJsonTable() {
        return accountTable;
    }

    @PostMapping("/register")
    public Account register( @RequestParam String name, @RequestParam String email, @RequestParam String password) {
        password = Algorithm.getMd5(password);
        for (Account account : accountTable){
            if(account.email.equals(email) || (name.isBlank()) || account.validate()){
                return null;
            }
        }
        return new Account(name, email, password);
    }

    @PostMapping("/login")
    public Account login
            (
                @RequestParam String email,
                @RequestParam String password
            )
    {
        password = Algorithm.getMd5(password);
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
                @RequestParam int id,
                @RequestParam String username,
                @RequestParam  String address,
                @RequestParam String phoneNumber,
                @PathVariable String email, 
                @PathVariable String password
            )
        {
            for (Account account : accountTable) {
                if (account.id == id) {
                    Renter renter = new Renter(username, address, phoneNumber);
                    account.renter = renter;
                    return renter;
                }
            }
            return null;

        }

    @PostMapping("/{id}/topUp")
    public boolean topUp
    (
        @RequestParam int id,
        @RequestParam double balance,
        @PathVariable String email, 
        @PathVariable String password
    ) 
    {
        return false;
    }
}
