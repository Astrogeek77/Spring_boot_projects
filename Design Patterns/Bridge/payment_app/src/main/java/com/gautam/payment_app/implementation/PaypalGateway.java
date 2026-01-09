package com.gautam.payment_app.implementation;

import org.springframework.stereotype.Component;

@Component
public class PaypalGateway implements PaymentGateway {
    @Override
    public void processPayment(String paymentType) {
        System.out.println("PayPal: Processing " + paymentType + " request securely.");
    }
}
