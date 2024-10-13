package com.Data.Custom.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {


@GetMapping("/")
public String get(){

    return "home";
}
    @GetMapping("/userpanel")
    public String user() {

        return "userpanel";
    }


}
