package com.example.wigellcinema.controllers;

import com.example.wigellcinema.models.Bookings;
import com.example.wigellcinema.models.Movies;
import com.example.wigellcinema.models.Room;
import com.example.wigellcinema.models.User;
import com.example.wigellcinema.repository.BookingRepository;
import com.example.wigellcinema.repository.UserRepository;
import com.example.wigellcinema.service.BookingService;
import com.example.wigellcinema.service.MovieService;
import com.example.wigellcinema.service.RoomService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v4")


public class UserController {
    private static final Logger logger = Logger.getLogger(UserController.class);


    @Autowired
    private MovieService movieService;
    @Autowired
    private RoomService roomService;
    @Autowired
    private BookingService bookingService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookingRepository bookingRepository;


   @RequestMapping("/movies")
   @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<Movies>> getAllMovies() {
       logger.info("Fetching all movies");
        List<Movies> movies = movieService.getAllMovies();
     return new ResponseEntity<>(movies, HttpStatus.OK);
    }
    @RequestMapping("/mybookings")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<Bookings>> getAllBookings() {
        logger.info("Fetching all bookings");
        List<Bookings> bookings = bookingService.myBookings();
        return new ResponseEntity<>(bookings,HttpStatus.OK);
    }
    @PostMapping("/bookroom")
    ResponseEntity<?> bookRoom(@Validated @RequestBody Bookings booking, Room room){
       logger.info("Processing booking request");
       Optional<User> user = userRepository.findById(booking.getId());

        if (user == null || room == null) {
            logger.warn("Invalid customer and room provided in booking request");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Customer not found.");
        }
       Room bookedRoom = roomService.BookRoom(room);
       booking.setRoom(bookedRoom);
       bookingRepository.save(booking);
       logger.info("Booking created successfully");
        return ResponseEntity.ok("Booking saved.");
    }
    @PutMapping("/updatebooking/{id}")
    @PreAuthorize("hasRole('USER')")

    public ResponseEntity<Bookings> updateBooking(@PathVariable int id, @RequestBody Bookings booking) {
        logger.info("Updating booking with ID: {}");

        try {
            Bookings updatedBooking = bookingService.updateBooking(id, booking);

            if (updatedBooking != null) {
                logger.info("Booking updated successfully with ID: {}");
                return ResponseEntity.ok(updatedBooking);
            } else {
                logger.warn("Booking with ID: {} not found");
                return ResponseEntity.notFound().build();
            }
        } catch (Exception ex) {
            logger.error("Error updating booking with ID: {}", ex);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @GetMapping("/bookings/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Bookings> getBookingById(@PathVariable("id") int id) {
        Bookings booking = bookingService.getBookingById(id);
        if (booking != null) {
            return ResponseEntity.ok(booking);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}


