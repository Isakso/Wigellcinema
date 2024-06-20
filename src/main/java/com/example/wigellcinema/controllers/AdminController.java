package com.example.wigellcinema.controllers;

import com.example.wigellcinema.models.Movies;
import com.example.wigellcinema.models.Room;
import com.example.wigellcinema.models.User;
import com.example.wigellcinema.service.MovieService;
import com.example.wigellcinema.service.RoomService;
import com.example.wigellcinema.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v4")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

    @Autowired
    private UserService customerService;
    @Autowired
    private MovieService movieService;
    @Autowired
    private RoomService roomService;

    @GetMapping("/customers")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<User>>getAllCustomers(){
        List<User>customers = customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }
    @PostMapping("/addmovie")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity <Movies> addMovie(Movies movie){
        movieService.addMovie(movie);
        return ResponseEntity.ok(movie);

    }
    @DeleteMapping("/deletemovie/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteMovie(@PathVariable int id){
        movieService.deleteMovie(id);
        return ResponseEntity.ok("Movie with Id "+ id +" deleted");
    }
    @PutMapping("/updatedroom/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public  ResponseEntity<Room> updateRoom(@PathVariable int id, @Validated @RequestBody Room room){
        Room updatedRoom = roomService.UpdateRoom(id, room);

        if(updatedRoom !=null){
            return ResponseEntity.ok(updatedRoom);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

}
