package com.pawm.project.rasp1Project40.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/login")

    public String login() {
        return "login.html";
    }

    @GetMapping("/")

    public String home() {
        return "index.html";
    }
}