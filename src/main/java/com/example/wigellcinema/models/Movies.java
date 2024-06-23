package com.example.wigellcinema.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.Set;

@Entity
@Table(name = "movies")
public class Movies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private int id;
    @Column(name = "title", length = 45)
    private String movieTitle;
    @Column(name = "genre", nullable = false)
    private String genre;
    @Column(name = "age_limit", nullable = false)
    private int ageLimit;
    @Column(name = "movie_length", nullable = false)
    private int movieLength;


    @OneToMany(cascade=CascadeType.REMOVE, fetch=FetchType.EAGER,mappedBy="movies", orphanRemoval=true)
    @Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
    private Set<Bookings> bookings;
    public int getId() {
        return id;
    }

     public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getMovieLength() {
        return movieLength;
    }

    public void setMovieLength(int movieLength) {
        this.movieLength = movieLength;
    }

    public int getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(int ageLimit) {
        this.ageLimit = ageLimit;
    }

    public Set<Bookings> getBookings() {
        return bookings;
    }
    public void setBookings(Set<Bookings> bookings) {
        this.bookings = bookings;
    }
}
