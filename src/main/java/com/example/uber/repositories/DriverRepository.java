package com.example.uber.repositories;

import com.example.uber.entities.Driver;
import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
    @Query(value = "Select d.* , ST_Distance(d.current_location, :pickupLocation) AS distance " +
    "From driver AS d " +
    "where available = true AND ST_DWithin(d.current_location, :pickupLocation, 10000) " +
    "Order by distance " +
    "Limit 10", nativeQuery = true)
    List<Driver> findTenNearestMatchingDrivers(Point pickupLocation);

    @Query(value = "Select d.* " +
    "From driver d " +
    "where d.available = true and ST_DWithin(d.current_location, :pickupLocation, 15000) " +
    "Order by d.rating DESC " +
    "Limit 10", nativeQuery = true)
    List<Driver> findTenNearbyTopRatedDrivers(Point pickupLocation);
}
