package com.nhtoan611.demo.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunController {
    @Value("${coach.name}")
    private String coachName;

    @GetMapping("/")
    public String sayHello() {
        return "Hello world";
    }

    @GetMapping("/learn")
    public String learnForFuture() {
        return coachName;
    }
}
