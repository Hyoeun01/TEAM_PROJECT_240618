package com.example.hotel_arcana.Main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
    @GetMapping("/Main")
    public String test() {
        return "Main";
    }
    @GetMapping("/room/STANDARD")
    public String room1() {
         return "/Room/STANDARD";
    }
    @GetMapping("/room/DELUXE")
    public String room2() {
        return "/ROOM/DELUXE";
    }
    @GetMapping("/room/VVIP")
    public String room3() {
        return "/ROOM/VVIP";
    }
    @GetMapping("/room/VIP")
    public String room4() {
        return "/ROOM/VIP";
    }
    @GetMapping("/room/SUPERIOR")
    public String room5() {
        return "/ROOM/SUPERIOR";
    }
    @GetMapping("/room/SUITE")
    public String room6() {
        return "/ROOM/SUITE";
    }
}
