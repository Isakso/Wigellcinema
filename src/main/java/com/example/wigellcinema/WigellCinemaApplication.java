package com.example.wigellcinema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.example.wigellcinema.models")

public class WigellCinemaApplication {


    public static void main(String[] args) {
        SpringApplication.run(WigellCinemaApplication.class, args);
    }

}
