package com.example.wigellcinema.controllers;

import com.example.wigellcinema.models.Bookings;
import com.example.wigellcinema.models.Movies;
import com.example.wigellcinema.models.Room;
import com.example.wigellcinema.service.BookingService;
import com.example.wigellcinema.service.MovieService;
import com.example.wigellcinema.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v4")

@PreAuthorize("hasRole('USER')")
public class UserController {

    @Autowired
    private MovieService movieService;
    @Autowired
    private RoomService roomService;

    @Autowired
    private BookingService bookingService;

   @RequestMapping("/movies")
   @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<Movies>> getAllMovies() {
        List<Movies> movies = movieService.getAllMovies();
        return ResponseEntity.ok(movies);

    }
    @RequestMapping("/mybookings")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<Bookings>> getAllBookings() {
        List<Bookings> bookings = bookingService.myBookings();
        return ResponseEntity.ok(bookings);

    }
    @RequestMapping("/bookroom")
    ResponseEntity<Room> addUser(@Validated @RequestBody Room room){
       Room bookedRoom = roomService.BookRoom(room);
       return ResponseEntity.ok(bookedRoom);
    }
    @PutMapping("/updatebooking/{id}")
    @PreAuthorize("hasRole('USER')")
    ResponseEntity<Bookings> updateBooking(@PathVariable int id, @Validated @RequestBody Bookings booking){

        Bookings updatedBooking = bookingService.UpdateBooking(id, booking);
        if (updatedBooking!= null) {
            return ResponseEntity.ok(updatedBooking);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

}
