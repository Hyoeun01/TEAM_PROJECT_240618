package com.example.hotel_arcana.login.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class IndexController {
    @GetMapping("/")
    public String index() {
        return "MyPage";
    }
    @GetMapping("/test1")
    public String test1() {
        return "/test1";
    }

    @GetMapping("/header")
    public String header() {
        return "/headertest";
    }
}
