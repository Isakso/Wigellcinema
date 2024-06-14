package com.example.wigellcinema.models;

import jakarta.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue
    @Column(name ="id")
    private int id;
    @Column(name ="name", nullable = false)
    private String user_name;
    @Column(name ="address", nullable = false)
    private String address;

    public Customer(){

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
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}
