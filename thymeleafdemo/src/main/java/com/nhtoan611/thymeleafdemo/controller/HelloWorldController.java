package com.nhtoan611.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
    @GetMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    @RequestMapping("/proccessForm")
    public String proccessForm() {
        return "helloworld";
    }

    @PostMapping("/proccessFormV2")
    public String readDataForm(HttpServletRequest request, Model model) {
        String name = request.getParameter("studentName");
        name = name.toUpperCase() + " YOO!";
        model.addAttribute("name", name);
        return "helloworld";
    }
}
