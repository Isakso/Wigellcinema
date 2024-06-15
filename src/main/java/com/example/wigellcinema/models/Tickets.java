package com.example.wigellcinema.models;

import jakarta.persistence.*;

@Entity
public class Tickets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private int id;

    @Column(name = "ticket_type")
    private String ticketType;







}
