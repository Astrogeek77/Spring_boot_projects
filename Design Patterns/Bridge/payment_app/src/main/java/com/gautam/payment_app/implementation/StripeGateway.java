package com.gautam.payment_app.implementation;

import org.springframework.stereotype.Component;

@Component
public class StripeGateway implements PaymentGateway {
    @Override
    public void processPayment(String paymentType) {
        System.out.println("Stripe: Authorizing " + paymentType + " transaction via API.");
    }
}