package com.example.uber.configs;

import com.example.uber.dto.PointDto;
import com.example.uber.utils.GeometryUtil;
import org.locationtech.jts.geom.Point;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper modelMapper() {

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.typeMap(PointDto.class, Point.class).setConverter(converter -> {
            PointDto pointDto = converter.getSource();
            return GeometryUtil.createPoint(pointDto);
        });

        modelMapper.typeMap(Point.class, PointDto.class).setConverter(context -> {
            Point point = context.getSource();
            double coordinate[] = {
                    point.getX(),
                    point.getY()
            };
            return new PointDto(coordinate);
        });

        return modelMapper;
    }
}
