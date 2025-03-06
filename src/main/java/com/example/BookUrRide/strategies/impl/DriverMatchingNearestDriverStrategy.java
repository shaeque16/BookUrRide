package com.example.BookUrRide.strategies.impl;

import com.example.BookUrRide.entities.Driver;
import com.example.BookUrRide.entities.RideRequest;
import com.example.BookUrRide.repositories.DriverRepository;
import com.example.BookUrRide.strategies.DriverMatchigStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DriverMatchingNearestDriverStrategy implements DriverMatchigStrategy {

    private final DriverRepository driverRepository;

    @Override
    public List<Driver> findMatchingDriver(RideRequest rideRequest) {
        return driverRepository.findTenNearestMatchingDrivers(rideRequest.getDropoffLocation());
    }
}
