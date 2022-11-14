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

@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account>
{
    public final static String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
    @JsonAutowired(value = Account.class, filepath = "src/json/account.json")
    public static JsonTable<Account> accountTable;
    public final static Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);
    public final static String REGEX_EMAIL = "^[a-zA-Z0-9 ][a-zA-Z0-9]+@[a-zA-Z.]+?\\.[a-zA-Z]+?$";
    public final static Pattern REGEX_PATTERN_EMAIL =Pattern.compile(REGEX_EMAIL);

    public JsonTable<Account> getJsonTable() {
        return accountTable;
    }

    @PostMapping("/login")
    Account login(
            @RequestParam String email,
            @RequestParam String password
    ){
        String encrypted = null;
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytes = md.digest(password.getBytes());
            StringBuilder stringbuilder = new StringBuilder();
            for(int i=0; i<bytes.length; i++){
                stringbuilder.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            encrypted = stringbuilder.toString();
        }catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        String finalEncrypted = encrypted;
        Account temp = Algorithm.<Account>find(accountTable, pred -> email.equals(pred.email) && password.equals(pred.password));
        return temp;
    }

    @PostMapping("/register")
    Account register(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String password
    ){
        String encrypted = null;
        Matcher matcheremail = REGEX_PATTERN_EMAIL.matcher(email);
        boolean emailstatus = matcheremail.find();
        Matcher matcherpassword = REGEX_PATTERN_PASSWORD.matcher(password);
        boolean passwordstatus = matcherpassword.find();
        if(passwordstatus && emailstatus && !name.isBlank()){
            try{
                MessageDigest md = MessageDigest.getInstance("MD5");
                byte[] bytes = md.digest(password.getBytes());
                StringBuilder stringbuilder = new StringBuilder();
                for(int i=0; i<bytes.length; i++){
                    stringbuilder.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
                }
                encrypted = stringbuilder.toString();
            }
            catch(NoSuchAlgorithmException e){
                e.printStackTrace();
            }
            accountTable.add(new Account(name,email,password));
            return new Account(name, email, password);
        }
        else{
            return null;
        }

    }

    @PostMapping("/{id}/registerRenter")
    Renter registerRenter(@PathVariable int id, @RequestParam String username, @RequestParam String address,
                          @RequestParam String phoneNumber ){
        Account temp = Algorithm.<Account>find(accountTable,pred -> pred.id == id);
        if(temp.renter == null && temp != null){
            temp.renter = new Renter(username, address, phoneNumber);
            return temp.renter;
        }
        else{
            return null;
        }
    }

    @PostMapping("/{id}/topUp")
    boolean topUp(@PathVariable int id, @RequestParam double balance ){
        Account account = Algorithm.<Account>find(accountTable, acc -> id == acc.id);
        if (account != null){
            account.balance += balance;
            return true;
        }else{
            return false;
        }
    }
}