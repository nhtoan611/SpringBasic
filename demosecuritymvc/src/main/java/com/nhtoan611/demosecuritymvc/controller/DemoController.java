package com.nhtoan611.demosecuritymvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
    @GetMapping("/")
    public String showHome() {
        return "home";
    }

    @GetMapping("/leaders")
    public String showLeaderPage() {
        return "leader-page";
    }

    @GetMapping("/admin")
    public String showAdinPage() {
        return "admin-page";
    }
}
