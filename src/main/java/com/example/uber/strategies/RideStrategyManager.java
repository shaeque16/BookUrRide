package com.example.uber.strategies;

import com.example.uber.strategies.impl.DriverMatchingHighestRatedDriverStrategy;
import com.example.uber.strategies.impl.DriverMatchingNearestDriverStrategy;
import com.example.uber.strategies.impl.RideFareSurgePricingFareCalculationStrategy;
import com.example.uber.strategies.impl.RiderFareDefaultFareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
@RequiredArgsConstructor
public class RideStrategyManager {

    private final DriverMatchingHighestRatedDriverStrategy highestRatedDriverStrategy;
    private final DriverMatchingNearestDriverStrategy nearestDriverStrategy;
    private final RideFareSurgePricingFareCalculationStrategy surgePricingFareCalculationStrategy;
    private final RiderFareDefaultFareCalculationStrategy defaultFareCalculationStrategy;

    public DriverMatchigStrategy driverMatchigStrategy(double rating){

        if(rating >= 4.8){
            return highestRatedDriverStrategy;
        }
        else
            return  nearestDriverStrategy;
    }

    public RidefareCalculationStrategy ridefareCalculationStrategy(){

        LocalTime surgeStartTime = LocalTime.of(18,0);
        LocalTime surgeEndTime = LocalTime.of(21,0);
        LocalTime currentTime = LocalTime.now();

        boolean isSurgeTime = currentTime.isAfter(surgeStartTime) && currentTime.isBefore(surgeEndTime);

        if(isSurgeTime){
            return surgePricingFareCalculationStrategy;
        }
        else
            return defaultFareCalculationStrategy;
    }


}
