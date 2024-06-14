package com.example.wigellcinema.service;

import com.example.wigellcinema.models.Customer;
import com.example.wigellcinema.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements CustomerServiceInterface {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public List<Customer> getAllCustomers() {


        return customerRepository.findAll();
    }
}
