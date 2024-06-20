package com.example.wigellcinema.service;

import com.example.wigellcinema.models.Bookings;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface BookingServiceInterface {


    List<Bookings> myBookings();

   Bookings UpdateBooking(int id, Bookings booking);


}
