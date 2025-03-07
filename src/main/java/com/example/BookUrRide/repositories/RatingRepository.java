package com.example.BookUrRide.repositories;

import com.example.BookUrRide.entities.Driver;
import com.example.BookUrRide.entities.Rating;
import com.example.BookUrRide.entities.Ride;
import com.example.BookUrRide.entities.Rider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {

    List<Rating> findByRider(Rider rider);
    List<Rating> findByDriver(Driver driver);

    Optional<Rating> findByRide(Ride ride);
}
