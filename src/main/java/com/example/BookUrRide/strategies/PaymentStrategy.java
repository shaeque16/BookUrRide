package com.example.BookUrRide.strategies;

import com.example.BookUrRide.entities.Payment;

public interface PaymentStrategy {
    Double PLATFORM_COMMISSION = 0.3;
    void processPayment(Payment payment);
}
