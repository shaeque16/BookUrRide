package com.example.BookUrRide.strategies;

import com.example.BookUrRide.entities.Driver;
import com.example.BookUrRide.entities.RideRequest;

import java.util.List;

public interface DriverMatchigStrategy {
    List<Driver> findMatchingDriver(RideRequest rideRequest);
}
