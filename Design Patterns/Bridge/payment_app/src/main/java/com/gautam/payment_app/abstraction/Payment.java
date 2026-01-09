package com.gautam.payment_app.abstraction;

import com.gautam.payment_app.implementation.PaymentGateway;

public abstract class Payment {

    // --- THIS IS THE BRIDGE ---
    protected PaymentGateway gateway;

    public Payment(PaymentGateway gateway) {
        this.gateway = gateway;
    }

    public abstract void makePayment();
}
