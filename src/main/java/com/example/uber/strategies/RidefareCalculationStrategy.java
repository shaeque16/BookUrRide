package com.example.uber.strategies;

import com.example.uber.entities.RideRequest;

public interface RidefareCalculationStrategy {

    double RIDE_FARE_MULTIPLIER = 10;

    double calculateFare(RideRequest rideRequest);
}
