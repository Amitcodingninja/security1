package com.security.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {
    @GetMapping("/index")
    public String indexPage() {

        return "index";
    }

    @GetMapping("/member")
    public String memberPage() {

        return "member";
    }

    @GetMapping("/admin")
    public String adminPage() {

        return "admin";
    }

    @GetMapping("/error")
    public String errorPage() {

        return "error";
    }


}
