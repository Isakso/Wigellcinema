package com.example.wigellcinema.controllers;

import com.example.wigellcinema.models.Customer;
import com.example.wigellcinema.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v4")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>>getAllCustomers(){
        List<Customer>customers = customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

}
