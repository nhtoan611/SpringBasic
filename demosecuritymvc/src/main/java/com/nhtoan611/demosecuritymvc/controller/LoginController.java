package com.nhtoan611.demosecuritymvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/showLoginPage")
    public String showLoginForm() {
        return "login-form";
    }

    // Add request mapping for access denied
    @GetMapping("/access-denied")
    public String showDeniedPage() {
        return "denied-page";
    }
}
