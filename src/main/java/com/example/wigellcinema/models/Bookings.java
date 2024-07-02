package com.example.wigellcinema.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Bookings")
public class Bookings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "no_of_guests", length = 45)
    private int numberOfGuests;

    @Column(name = "booking_date",nullable = false)
    private LocalDate bookingDate;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_id")
    private Movies movies;
    @OneToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @Column(name = "total_cost")
    private long totalCost;

    @Column(name = "total_cost_eur")
    private Double totalCostEur;

    public Bookings() {
        // Default constructor
    }

    // Getters and setters

    public int getId() {
        return id;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Movies getMovies() {
        return movies;
    }

    public void setMovies(Movies movies) {
        this.movies = movies;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public long getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(long totalCost) {
        this.totalCost = totalCost;
    }
    public Double getTotalCostEur() {
        return totalCostEur;
    }
    public void setTotalCostEur(Double totalCostEur) {
        this.totalCostEur = totalCostEur;
    }
}
