package com.example.BookUrRide.services;

import com.example.BookUrRide.entities.Payment;
import com.example.BookUrRide.entities.Ride;
import com.example.BookUrRide.entities.enums.PaymentStatus;

public interface PaymentService {

    void processPayment(Ride ride);

    Payment createNewPayment(Ride ride);

    void updatePaymentStatus(Payment payment, PaymentStatus status);
}
