package com.example.wigellcinema.models;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="user_id")
    private int id;
    @Column(name ="user_name", nullable = false)
    private String user_name;
    @ManyToOne
    @JoinColumn(name = "address_id" )
    private Address address;
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    public User(){

    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUser_name() {
        return user_name;
    }
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
}
