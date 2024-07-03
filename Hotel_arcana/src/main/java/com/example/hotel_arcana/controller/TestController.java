package com.example.hotel_arcana.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
    @GetMapping("/test")
    public String test() {
        return "testfile.html";
    }
    @GetMapping("/twin city")
    public String room1() {
         return "/Room/twin city view.html";
    }
    @GetMapping("/Presidential")
    public String room2() {
        return "/Room/Presidential.html";
    }
    @GetMapping("/Delux1")
    public String room3() {
        return "/Room/Delux double.html";
    }
    @GetMapping("/Delux2")
    public String room4() {
        return "/Room/Delux sweetie.html";
    }
    @GetMapping("/Royal")
    public String room5() {
        return "/Room/Royal sweet.html";
    } @GetMapping("/Junior")
    public String room6() {
        return "/Room/Junior.html";
    }
}
