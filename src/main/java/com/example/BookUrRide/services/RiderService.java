package com.example.BookUrRide.services;

import com.example.BookUrRide.dto.DriverDto;
import com.example.BookUrRide.dto.RideDto;
import com.example.BookUrRide.dto.RideRequestDto;
import com.example.BookUrRide.dto.RiderDto;
import com.example.BookUrRide.entities.Rider;
import com.example.BookUrRide.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface RiderService {


    RideRequestDto requestRide(RideRequestDto rideRequestDto);

    RideDto cancelRide(Long rideId);

    DriverDto rateDriver(Long rideId, Integer rating);

    RiderDto getMyProfile();

    Page<RideDto> getMyRides(PageRequest pageRequest);

    Rider createNewRider(User user);

    Rider getCurrentRider();

}
