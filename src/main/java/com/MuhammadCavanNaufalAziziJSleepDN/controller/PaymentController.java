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


/**
 * The PaymentController class implements the BasicGetController interface.
 * It contains methods to create, accept and cancel a payment.
 *
 * @version 1.0
 */
@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment> {
    @JsonAutowired(value = Payment.class, filepath = "src/json/payment.json")
    public static JsonTable<Payment> paymentTable;

    @Override
    @GetMapping("/payment")
    public JsonTable<Payment> getJsonTable() {
        return paymentTable;
    }

    /**
     * Cancels a payment with the given ID.
     *
     * @param id the ID of the payment to cancel
     * @return true if the payment was successfully cancelled, false otherwise
     */
    @PostMapping("/{id}/cancel")
    public boolean cancel(
            @PathVariable int id
    ){
        Payment payment = Algorithm.<Payment>find(getJsonTable(), pred -> pred.id == id);
        if(payment != null && payment.status == Invoice.PaymentStatus.WAITING){
            payment.status = Invoice.PaymentStatus.FAILED;
            Account buyer = Algorithm.<Account>find(AccountController.accountTable, pred -> pred.id == payment.buyerId);
            Room room = Algorithm.<Room>find(RoomController.roomTable, pred -> pred.id == payment.renterId);
            buyer.balance += room.price.price;
            return true;
        }
        return false;
    }

    /**
     * Accepts a payment with a given ID.
     *
     * @param id the ID of the payment to accept
     * @return true if the payment was accepted successfully, false otherwise
     */
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


    /**
     * Creates a new Payment object.
     *
     * @param buyerId the ID of the buyer
     * @param renterId the ID of the renter
     * @param roomId the ID of the room
     * @param from the date the payment is being made from
     * @param to the date the payment is being made to
     * @return the created Payment object, or null if the payment could not be made
     */
    @PostMapping("/create")
    public Payment create( @RequestParam int buyerId, @RequestParam int renterId, @RequestParam int roomId,  @RequestParam String from,@RequestParam String to){
        Room roomCheck = Algorithm.<Room>find(RoomController.roomTable, room -> room.id == roomId);
        Account accountCheck = Algorithm.<Account>find(AccountController.accountTable, acc -> acc.id == buyerId);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date fromTgl = sdf.parse(from);
            Date toTgl = sdf.parse(to);
            long day = toTgl.getTime() - fromTgl.getTime();
            double totalPay = roomCheck.price.price * (TimeUnit.MILLISECONDS.toDays(day));
            if(accountCheck != null && roomCheck != null && totalPay <= accountCheck.balance && Payment.availability(fromTgl, toTgl, roomCheck)){
                Payment paid = new Payment(buyerId, renterId, roomId, fromTgl, toTgl);
                accountCheck.balance -= totalPay;
                paid.totalPrice = totalPay;
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
}