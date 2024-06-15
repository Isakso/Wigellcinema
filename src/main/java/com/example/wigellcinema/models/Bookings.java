package com.example.wigellcinema.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Bookings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "no_of_guests")
    private int numberOfGuests;
    @Column(name = "booking_date")
    private LocalDate bookingDate;

    public Bookings(){

    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }
}
