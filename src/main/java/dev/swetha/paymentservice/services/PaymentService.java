package dev.swetha.paymentservice.services;

import dev.swetha.paymentservice.services.paymentgateway.PaymentGatewaySelector;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private PaymentGatewaySelector paymentGatewaySelector;
    public PaymentService(PaymentGatewaySelector paymentGatewaySelector) {
        this.paymentGatewaySelector = paymentGatewaySelector;
    }
    public String generatePaymentLink() {
        //write logic to add details in db

return  paymentGatewaySelector.getPaymentGateway().generatePaymentLink();
    }
}
