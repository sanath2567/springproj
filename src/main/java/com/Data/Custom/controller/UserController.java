package com.Data.Custom.controller;



import com.Data.Custom.users.Users;
import com.Data.Custom.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserController {
    @Autowired
    private userService service;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Users user) {
        service.registerUser(user);
        return ResponseEntity.ok("User registered successfully");
    }
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
    @GetMapping("/home")
    public String home() {
        return "home";
    }


}
