package com.example.wigellcinema.repository;

import com.example.wigellcinema.models.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Bookings, Integer> {

}
