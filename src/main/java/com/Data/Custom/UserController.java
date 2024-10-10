package com.Data.Custom;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;


import java.util.List;

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
