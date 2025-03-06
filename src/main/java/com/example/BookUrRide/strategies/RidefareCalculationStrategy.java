package com.example.BookUrRide.strategies;

import com.example.BookUrRide.entities.RideRequest;

public interface RidefareCalculationStrategy {

    double RIDE_FARE_MULTIPLIER = 10;

    double calculateFare(RideRequest rideRequest);
}
