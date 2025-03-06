package com.example.BookUrRide.dto;

import com.example.BookUrRide.entities.enums.PaymentMethod;
import com.example.BookUrRide.entities.enums.RideStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RideDto {

    //Two ride dto for rider and driver
    private Long id;
    private PointDto pickupLocation;
    private PointDto dropOffLocation;

    private LocalDateTime createdTime;
    private RiderDto rider;
    private DriverDto driver;
    private PaymentMethod paymentMethod;

    private RideStatus rideStatus;

    private String otp;
    private Double fare;
    private LocalDateTime startedTime;
    private LocalDateTime endedTime;
}
