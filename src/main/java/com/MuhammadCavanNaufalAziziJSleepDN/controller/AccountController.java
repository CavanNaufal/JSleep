package com.MuhammadCavanNaufalAziziJSleepDN.controller;

import com.MuhammadCavanNaufalAziziJSleepDN.Account;
import com.MuhammadCavanNaufalAziziJSleepDN.Algorithm;
import com.MuhammadCavanNaufalAziziJSleepDN.Renter;
import com.MuhammadCavanNaufalAziziJSleepDN.dbjson.JsonAutowired;
import com.MuhammadCavanNaufalAziziJSleepDN.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * This is the AccountController class.
 * It implements the BasicGetController interface and provides methods for logging
 * in, registering, and managing user accounts.
 *
 * @author Muhammad Cavan Naufal Azizi
 */

@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account> {
    public static final String REGEX_EMAIL = "^[A-Z][a-zA-Z0-9_]{4,20}$";
    public static final String REGEX_PASSWORD = "^[0-9]{9,12}$";
    public static final Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);
    public static final Pattern  REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);

    @JsonAutowired(value = Account.class, filepath = "src/json/account.json")
    public static JsonTable<Account> accountTable;

    @GetMapping("/account")
    public JsonTable<Account> getJsonTable() {
        return accountTable;
    }

    @PostMapping("/login")
    Account login( @RequestParam String email, @RequestParam String password) {
        try {
            MessageDigest MD = MessageDigest.getInstance("MD5");
            MD.update(password.getBytes());
            byte[] bytes = MD.digest();
            StringBuilder strBuild = new StringBuilder();
            int i = 0;
            while (i < bytes.length) {
                strBuild.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
                i++;
            }
            password = strBuild.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        for (Account data : accountTable) {
            if (data.password.equals(password) && data.email.equals(email)) {return data;}
        }
        return null;
    }

    @PostMapping("/register")
    Account register( @RequestParam String name, @RequestParam String email, @RequestParam String password) {
        boolean findEmail = REGEX_PATTERN_EMAIL.matcher(email).find();
        boolean findPassword = REGEX_PATTERN_PASSWORD.matcher(password).find();
        try {
            MessageDigest MD = MessageDigest.getInstance("MD5");
            MD.update(password.getBytes());
            byte[] bytes = MD.digest();
            StringBuilder strBuild = new StringBuilder();
            for (byte aByte : bytes) {
                strBuild.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }
            password = strBuild.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        if (findEmail || findPassword || !name.isBlank() && !accountTable.stream().anyMatch(account -> account.email.equals(email))) {
            Account account = new Account(name, email, password);
            accountTable.add(account);
            return account;
        }
        else{
            return null;
        }
    }
    @PostMapping("/{id}/registerRenter")
    Renter registerRenter (@PathVariable int id,
                           @RequestParam String username,
                           @RequestParam  String address,
                           @RequestParam String phoneNumber) {
        for (Account account : getJsonTable()) {
            if (account.id == id && account.renter == null) {
                Renter renter = new Renter (username, phoneNumber, address);
                account.renter = renter;
                return renter;
            }
        }
        return null;

    }

    @PostMapping("/{id}/topUp")
    boolean topUp (@PathVariable int id, @RequestParam double balance) {
        Account found = Algorithm.<Account>find(getJsonTable(), acc -> acc.id == id);
        if(found != null){
            found.balance += balance;
            return true;
        }else{
            return false;
        }
    }
}