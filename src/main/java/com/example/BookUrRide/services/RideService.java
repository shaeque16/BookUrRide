package com.example.BookUrRide.services;

import com.example.BookUrRide.entities.Driver;
import com.example.BookUrRide.entities.Ride;
import com.example.BookUrRide.entities.RideRequest;
import com.example.BookUrRide.entities.Rider;
import com.example.BookUrRide.entities.enums.RideStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface RideService {

    Ride getRideById(Long rideId);

    Ride createNewRide(RideRequest rideRequest, Driver driver);

    Ride updateRideStatus(Ride ride, RideStatus rideStatus);

    Page<Ride> getAllRidesOfRider(Rider rider, PageRequest pageRequest);

    Page<Ride> getAllRidesOfDriver(Driver driver, PageRequest pageRequest);
}
