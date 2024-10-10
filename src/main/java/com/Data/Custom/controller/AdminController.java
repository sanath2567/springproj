package com.Data.Custom.controller;

import com.Data.Custom.users.Users;
import com.Data.Custom.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private userService service;

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminPanel(Model model) {
        List<Users> users = service.getAllUsers();
        model.addAttribute("users", users);
        return "admin";
    }


    @GetMapping("/access-denied")
    public String accessDenied() {
        return "access-denied";
    }
}
