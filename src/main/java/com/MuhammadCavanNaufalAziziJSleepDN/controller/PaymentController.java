package com.MuhammadCavanNaufalAziziJSleepDN.controller;

import com.MuhammadCavanNaufalAziziJSleepDN.Payment;
import com.MuhammadCavanNaufalAziziJSleepDN.dbjson.JsonAutowired;
import com.MuhammadCavanNaufalAziziJSleepDN.dbjson.JsonTable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment>{
    @JsonAutowired(filepath = "payment.json", value = Payment.class)
    public static JsonTable<Payment> paymentTable;

    
    @PostMapping("/create")
    public Payment create(
            @RequestParam int buyerId,
            @RequestParam int renterId,
            @RequestParam int roomId,
            @RequestParam String from,
            @RequestParam String to
    )
    {
        return null;
    }

    @GetMapping("/payment")
    public JsonTable<Payment> getJsonTable(){
        return paymentTable;
    }

    //find account buyer with buyerId from payment, find room with getRoomId from payment,change status payment to invoice.PaymentStatus.FAILED
    @PostMapping("/{id}/cancel")
    public boolean cancel 
        (
                @RequestParam int id
        )
        {
        return true;
        }

}
