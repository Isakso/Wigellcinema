package com.example.wigellcinema.service;
import com.example.wigellcinema.exceptions.ResourceNotFoundException;
import com.example.wigellcinema.models.Bookings;
import com.example.wigellcinema.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService implements BookingServiceInterface{

    @Autowired
    private BookingRepository bookingRepository;
    @Override
    public List<Bookings> myBookings() {
        return bookingRepository.findAll();
    }
    @Override
    public Bookings UpdateBooking(int id, Bookings booking) {

        if(bookingRepository.existsById(id)){

            Bookings currentBooking = bookingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Booking", "id", id));
            currentBooking.setRoom(booking.getRoom());
            currentBooking.setBookingDate(booking.getBookingDate());
            currentBooking.setMovies(booking.getMovies());
            currentBooking.setNumberOfGuests(booking.getNumberOfGuests());
            currentBooking.setUser(booking.getUser()
            );
            return bookingRepository.save(currentBooking);
        }
        throw new ResourceNotFoundException("Booking with", "id", id + "Unable to Update");


    }

}
