package com.example.uber.strategies.impl;

import com.example.uber.entities.RideRequest;
import com.example.uber.services.DistanceService;
import com.example.uber.strategies.RidefareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RideFareSurgePricingFareCalculationStrategy implements RidefareCalculationStrategy {

    private final DistanceService distanceService;
    private static final double SURGE_FACTOR = 2;

    @Override
    public double calculateFare(RideRequest rideRequest) {

        Double distance = distanceService.calculateDistance(rideRequest.getPickupLocation(), rideRequest.getDropoffLocation());

        return distance*RIDE_FARE_MULTIPLIER*SURGE_FACTOR;
    }
}
