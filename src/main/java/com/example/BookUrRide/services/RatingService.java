package com.example.BookUrRide.services;

import com.example.BookUrRide.dto.DriverDto;
import com.example.BookUrRide.dto.RiderDto;
import com.example.BookUrRide.entities.Ride;

public interface RatingService {

    DriverDto rateDriver(Ride ride, Integer rating);
    RiderDto rateRider(Ride ride, Integer rating);

    void createNewRating(Ride ride);
}
