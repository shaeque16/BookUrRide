package com.example.BookUrRide.services;

import com.example.BookUrRide.dto.DriverDto;
import com.example.BookUrRide.dto.SignupDto;
import com.example.BookUrRide.dto.UserDto;

public interface AuthService {

    String[] login(String email, String password);

    UserDto signup(SignupDto signupDto);

    DriverDto onboardNewDriver(Long userId, String vehicleId);

    String refreshToken(String refreshToken);

}
