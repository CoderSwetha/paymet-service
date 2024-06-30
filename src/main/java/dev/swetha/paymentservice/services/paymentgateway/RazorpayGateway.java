package dev.swetha.paymentservice.services.paymentgateway;

import com.razorpay.PaymentLink;
import org.springframework.stereotype.Service;
import org.json.JSONObject;
import com.razorpay.Payment;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@Service
public class RazorpayGateway implements PaymentGateway {
    @Override
    public String generatePaymentLink() {

        try {
            RazorpayClient razorpay = new RazorpayClient("rzp_test_soqL6uQLwB5NQm", "pYVapiLYwV7DAW9eoI9znxwd");
            JSONObject paymentLinkRequest = new JSONObject();
            paymentLinkRequest.put("amount", 1000);
            paymentLinkRequest.put("currency", "INR");
            paymentLinkRequest.put("accept_partial", true);
            paymentLinkRequest.put("first_min_partial_amount", 100);
            paymentLinkRequest.put("expire_by", 1720620823);
            paymentLinkRequest.put("reference_id", "TS198984932323");
            paymentLinkRequest.put("description", "Payment for policy no #23456");
            JSONObject customer = new JSONObject();
            customer.put("name", "Swetha Neela");
            customer.put("contact", "7989847944");
            customer.put("email", "swethaneela121@gmail.com");
            paymentLinkRequest.put("customer", customer);
            JSONObject notify = new JSONObject();
            notify.put("sms", true);
            notify.put("email", true);
            paymentLinkRequest.put("notify", notify);

            paymentLinkRequest.put("callback_url", "https://google.com/");
            paymentLinkRequest.put("callback_method", "get");

            PaymentLink payment = razorpay.paymentLink.create(paymentLinkRequest);

   return  payment.toString();
        } catch (Exception ex) {
            System.out.print(ex);
        }
        return  null;
    }
}



