package edu.miu.cs.cs489.pizzadeliveryapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"", "/", "/pizzamgm"})
public class HomePageController {

    @GetMapping(value = {"", "/home"})
    public String displayHomepage() {
        return "index";
    }

    @GetMapping(value = {"/about"})
    public String displayAboutUsPage() {
        return "about";
    }
}
