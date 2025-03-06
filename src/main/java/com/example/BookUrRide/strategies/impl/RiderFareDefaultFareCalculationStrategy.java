package com.example.BookUrRide.strategies.impl;

import com.example.BookUrRide.entities.RideRequest;
import com.example.BookUrRide.services.DistanceService;
import com.example.BookUrRide.strategies.RidefareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RiderFareDefaultFareCalculationStrategy implements RidefareCalculationStrategy {

    private final DistanceService distanceService;

    @Override
    public double calculateFare(RideRequest rideRequest) {
        double distance = distanceService.calculateDistance(rideRequest.getPickupLocation(), rideRequest.getDropoffLocation());

        return distance*RIDE_FARE_MULTIPLIER;
    }
}
