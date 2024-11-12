package com.example.uber.services.impl;

import com.example.uber.services.DistanceService;
import lombok.Data;
import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class DistanceServiceImpl implements DistanceService {

    private static final String OSRIM_API = "https://router.project-osrm.org/route/v1/driving/";

    @Override
    public double calculateDistance(Point src, Point dest) {

        String uri = src.getX()+","+src.getY()+";"+dest.getX()+","+dest.getY();

        try {
            OSRMResponseDto responseDto = RestClient.builder()
                    .baseUrl(OSRIM_API)
                    .build()
                    .get()
                    .uri(uri)
                    .retrieve()
                    .body(OSRMResponseDto.class);

            return responseDto.getRoutes().get(0).getDistance() / 1000;
        }

        catch (Exception e){
            throw new RuntimeException("Error getting data from OSRM"+ e.getMessage());
        }
    }
}

@Data
class OSRMResponseDto {
    private List<OSRMRoute> routes;
}

@Data
class OSRMRoute {
    private Double distance;
}