package com.example.wigellcinema.service;

import com.example.wigellcinema.exceptions.ResourceNotFoundException;
import com.example.wigellcinema.models.Bookings;
import com.example.wigellcinema.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService implements BookingServiceInterface {
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private CurrencyService currencyService;

    @Override
    public List<Bookings> myBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Bookings updateBooking(int id, Bookings booking) {
        try {
            if (bookingRepository.existsById(id)) {
                Bookings currentBooking = bookingRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Booking with", "id", id + " not found"));

                // Update fields from the provided booking object
                currentBooking.setBookingDate(booking.getBookingDate());
                currentBooking.setMovies(booking.getMovies());
                currentBooking.setNumberOfGuests(booking.getNumberOfGuests());
                currentBooking.setRoom(booking.getRoom());
                currentBooking.setUser(booking.getUser());
                currentBooking.setTotalCost(booking.getTotalCost());

                // Convert total cost to EUR
                double amountInSek = booking.getTotalCost(); // Assuming total cost is in SEK
                double amountInEur = currencyService.convertToEur(amountInSek);
                currentBooking.setTotalCostEur(amountInEur);

                // Save the updated booking
                return bookingRepository.save(currentBooking);
            } else {
                throw new ResourceNotFoundException("Booking with", "id", id + " not found");
            }
        } catch (Exception e) {
            // Log the exception for debugging purposes
            e.printStackTrace();
            throw new RuntimeException("Failed to update booking with id " + id, e);
        }
    }
    @Override
    public Bookings getBookingById(int id) {
        return bookingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Bookings", "Id", id));
    }
}







