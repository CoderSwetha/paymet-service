package dev.swetha.paymentservice.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RazorpayWebhookController {
    @PostMapping("/razorpayWebhook")
    public void paymentDone(@RequestBody Object object){
        System.out.println(object);
        //update the payment db table here

    }
}
