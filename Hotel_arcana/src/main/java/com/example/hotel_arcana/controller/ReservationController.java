package com.example.hotel_arcana.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservationController {

    @GetMapping("/reservation")
    public String reservation() {
        return "Reservation Success";
    }
}
