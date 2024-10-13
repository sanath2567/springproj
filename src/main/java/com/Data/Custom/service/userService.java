package com.Data.Custom.service;

import com.Data.Custom.users.Users;
import com.Data.Custom.repository.userRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private userRepo repo;

    public void registerUser(Users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repo.save(user);
    }
    public List<Users> getAllUsers() {

        return repo.findAll();
    }

}

