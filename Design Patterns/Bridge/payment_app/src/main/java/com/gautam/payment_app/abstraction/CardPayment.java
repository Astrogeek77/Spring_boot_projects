package com.gautam.payment_app.abstraction;

import com.gautam.payment_app.implementation.PaymentGateway;

public class CardPayment extends Payment {

    public CardPayment(PaymentGateway gateway) {
        super(gateway);
    }

    @Override
    public void makePayment() {
        System.out.println("--- Starting Card Payment ---");
        // Card specific logic
        System.out.println("Step 1: Validate Card Number");
        // Delegate actual processing to the bridge
        gateway.processPayment("Credit Card");
    }
}
