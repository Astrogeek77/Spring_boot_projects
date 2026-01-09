package com.gautam.payment_app.implementation;

public interface PaymentGateway {
    void processPayment(String paymentType);
}