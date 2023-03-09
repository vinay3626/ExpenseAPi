package com.tecnics.expense.contollers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class AuthCountrollerDemo {

    //
    @GetMapping("/")
    public String login(){
        return "authenticated successfully";
    }

    @GetMapping("/hello")
    public String sayHello(){
        return "Saying Hello";
    }
}
