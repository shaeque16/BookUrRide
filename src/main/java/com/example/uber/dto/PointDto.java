package com.example.uber.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PointDto {

    private double[] coordinate;
    private String type = "Point";

    public PointDto(double[] coordinate) {
        this.coordinate = coordinate;
    }
}
