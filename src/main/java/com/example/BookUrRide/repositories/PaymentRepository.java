package com.example.BookUrRide.repositories;

import com.example.BookUrRide.entities.Payment;
import com.example.BookUrRide.entities.Ride;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Optional<Payment> findByRide(Ride ride);
}
