package com.example.uber.strategies.impl;

import com.example.uber.entities.Driver;
import com.example.uber.entities.RideRequest;
import com.example.uber.repositories.DriverRepository;
import com.example.uber.strategies.DriverMatchigStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DriverMatchingHighestRatedDriverStrategy implements DriverMatchigStrategy {

    private  final DriverRepository driverRepository;

    @Override
    public List<Driver> findMatchingDriver(RideRequest rideRequest) {
            return driverRepository.findTenNearbyTopRatedDrivers(rideRequest.getPickupLocation());
    }
}
