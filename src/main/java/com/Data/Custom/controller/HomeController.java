package com.Data.Custom.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {



    @GetMapping("/user")
    public String user() {
        return "this is a user panel";
    }


}
