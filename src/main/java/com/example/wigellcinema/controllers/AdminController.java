package com.example.wigellcinema.controllers;

import com.example.wigellcinema.models.Movies;
import com.example.wigellcinema.models.Room;
import com.example.wigellcinema.models.User;
import com.example.wigellcinema.service.MovieService;
import com.example.wigellcinema.service.RoomService;
import com.example.wigellcinema.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v4")
public class AdminController {
    private static final Logger logger = Logger.getLogger(AdminController.class);

    @Autowired
    private UserService customerService;
    @Autowired
    private MovieService movieService;
    @Autowired
    private RoomService roomService;
    @GetMapping("/customers")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<User>>getAllCustomers(){
        logger.info("Fetching all customers");
        List<User>customers = customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }
    @PostMapping("/addmovie")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity <Movies> addMovie(Movies movie){
        logger.info("adding a movie");
        movieService.addMovie(movie);
        logger.info("movie added");
        return ResponseEntity.ok(movie);


    }
    @DeleteMapping("/deletemovie/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteMovie(@PathVariable int id, @RequestBody Movies movie){
        logger.info("deleting a movie");
               movieService.deleteMovie(movie.getId());
               logger.info("movie is deleted ");
        return ResponseEntity.ok("Movie with Id "+ id +" deleted");
    }
    @PutMapping("/updateroom/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public  ResponseEntity<Room> updateRoom(@PathVariable int id, @Validated @RequestBody Room room){
        logger.info("updating room in progress");
        Room updatedRoom = roomService.UpdateRoom(id, room);

        if(updatedRoom !=null){
            logger.info("room updated");
            return ResponseEntity.ok(updatedRoom);

        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

}
