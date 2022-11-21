package com.MuhammadCavanNaufalAziziJSleepDN.controller;

import com.MuhammadCavanNaufalAziziJSleepDN.*;
import com.MuhammadCavanNaufalAziziJSleepDN.dbjson.JsonAutowired;
import com.MuhammadCavanNaufalAziziJSleepDN.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment>{
    @JsonAutowired(filepath = "payment.json", value = Payment.class)
    public static JsonTable<Payment> paymentTable;

    @Override
    @GetMapping("/account")
    public JsonTable<Payment> getJsonTable(){
        return paymentTable;
    }

    @PostMapping("/create")
    public Payment create( @RequestParam int buyerId, @RequestParam int renterId, @RequestParam int roomId,  @RequestParam String from,@RequestParam String to){
        Room roomCheck = Algorithm.<Room>find(RoomController.roomTable, room -> room.id == roomId);
        Account accountCheck = Algorithm.<Account>find(AccountController.accountTable, acc -> acc.id == buyerId);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date fromTgl = sdf.parse(from);
            Date toTgl = sdf.parse(to);
            long day = toTgl.getTime() - fromTgl.getTime();
            double totalPrice = roomCheck.price.price * (TimeUnit.MILLISECONDS.toDays(day));
            if(roomCheck != null || accountCheck != null && totalPrice <= accountCheck.balance && Payment.availability(fromTgl, toTgl, roomCheck)){
                Payment paid = new Payment(buyerId, renterId, roomId, fromTgl, toTgl);
                accountCheck.balance -= totalPrice;
                paid.status = Invoice.PaymentStatus.WAITING;
                Payment.makeBooking(fromTgl, toTgl, roomCheck);
                paymentTable.add(paid);
                return paid;
            }else{
                return null;
            }
        } catch (ParseException p) {
            p.printStackTrace();
        }
        return null;
    }

    @PostMapping("/{id}/accept")
    boolean accept(@PathVariable int id){
        Payment payCheck = Algorithm.<Payment>find(paymentTable, payment -> payment.id == id);
        if (Invoice.PaymentStatus.WAITING.toString().equals("WAITING") && payCheck != null ) {
            payCheck.status = Invoice.PaymentStatus.SUCCESS;
            return true;
        }else {
            return false;
        }
    }

    @PostMapping("/{id}/cancel")
    boolean cancel(@PathVariable int id){

        Payment payCheck = Algorithm.<Payment>find(paymentTable, payment -> payment.id == id);
        Account accountCheck = Algorithm.<Account>find(AccountController.accountTable, account -> account.id == payCheck.buyerId);
        Room roomCheck = Algorithm.<Room>find(RoomController.roomTable, room -> room.id == payCheck.getRoomId());

        if (payCheck != null && Invoice.PaymentStatus.WAITING.toString().equals("WAITING")) {
            payCheck.status = Invoice.PaymentStatus.FAILED;
            accountCheck.balance += roomCheck.price.price;
            return true;
        }else{
            return false;
        }
    }
}