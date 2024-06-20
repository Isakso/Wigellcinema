package com.example.wigellcinema.service;

import com.example.wigellcinema.models.User;
import com.example.wigellcinema.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserServiceInterface {
    @Autowired
    private UserRepository customerRepository;

    @Override
    public List<User> getAllCustomers() {
       return customerRepository.findAll();
    }

}
