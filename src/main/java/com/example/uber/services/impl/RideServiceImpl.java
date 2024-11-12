package com.example.uber.services.impl;

import com.example.uber.dto.RideRequestDto;
import com.example.uber.entities.Driver;
import com.example.uber.entities.Ride;
import com.example.uber.entities.RideRequest;
import com.example.uber.entities.Rider;
import com.example.uber.entities.enums.RideRequestStatus;
import com.example.uber.entities.enums.RideStatus;
import com.example.uber.exceptions.ResourceNotFoundException;
import com.example.uber.repositories.RideRepository;
import com.example.uber.services.RideRequestService;
import com.example.uber.services.RideService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
@Slf4j
public class RideServiceImpl implements RideService {

    private final RideRepository rideRepository;
    private final RideRequestService rideRequestService;
    private final ModelMapper mapper;

    @Override
    public Ride getRideById(Long rideId) {
        return rideRepository.findById(rideId)
                .orElseThrow(() -> new ResourceNotFoundException("Ride not found with id: " + rideId));
    }

    @Override
    public Ride createNewRide(RideRequest rideRequest, Driver driver) {

        rideRequest.setRideRequestStatus(RideRequestStatus.CONFIRMED);

        Ride ride = mapper.map(rideRequest, Ride.class);
        ride.setRideStatus(RideStatus.CONFIRMED);
        ride.setDriver(driver);
        ride.setOtp(generateRandomOtp());
        ride.setId(null);

        rideRequestService.update(rideRequest);
        
        return rideRepository.save(ride);
    }

    @Override
    public Ride updateRideStatus(Ride ride, RideStatus rideStatus) {
        ride.setRideStatus(rideStatus);
        return rideRepository.save(ride);
    }

    @Override
    public Page<Ride> getAllRidesOfRider(Rider rider, PageRequest pageRequest) {
        return rideRepository.findByRider(rider, pageRequest);
    }

    @Override
    public Page<Ride> getAllRidesOfDriver(Driver driver, PageRequest pageRequest) {
        return rideRepository.findByDriver(driver, pageRequest);
    }

    private String generateRandomOtp(){
        Random random = new Random();
        int otpInt = random.nextInt(10000);

        return String.format("%04d", otpInt);
    }
}
