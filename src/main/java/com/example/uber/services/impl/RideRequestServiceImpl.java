package com.example.uber.services.impl;

import com.example.uber.entities.RideRequest;
import com.example.uber.exceptions.ResourceNotFoundException;
import com.example.uber.repositories.RideRequestRepository;
import com.example.uber.services.RideRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RideRequestServiceImpl implements RideRequestService {

    private final RideRequestRepository rideRequestRepository;

    @Override
    public RideRequest findRideRequestById(Long rideRequestId) {
        return rideRequestRepository.findById(rideRequestId).orElseThrow(() ->
                new ResourceNotFoundException("RideRequest not find with id: " + rideRequestId));
    }

    @Override
    public void update(RideRequest rideRequest) {
        rideRequestRepository.findById(rideRequest.getId())
                .orElseThrow(() -> new ResourceNotFoundException("RideRequest not found by id: " + rideRequest.getId()));
        rideRequestRepository.save(rideRequest);
    }
}
