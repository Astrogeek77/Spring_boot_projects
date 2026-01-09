package com.gautam.payment_app.abstraction;

import com.gautam.payment_app.implementation.PaymentGateway;

public class NetBankingPayment extends Payment {

    public NetBankingPayment(PaymentGateway gateway) {
        super(gateway);
    }

    @Override
    public void makePayment() {
        System.out.println("--- Starting Net Banking ---");
        // Net Banking specific logic
        System.out.println("Step 1: Redirect to Bank Login Page");
        // Delegate actual processing to the bridge
        gateway.processPayment("Net Banking");
    }
}
