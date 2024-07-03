package com.example.hotel_arcana.reservation.controller;

import com.example.hotel_arcana.reservation.service.ReservationService;
import com.example.hotel_arcana.room.dto.RoomDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reservation")
@RequiredArgsConstructor
public class ReservationRestController {

    private final ReservationService reservationService;

    @GetMapping("/rooms/{ROOM_NAME}")
    public List<RoomDTO> rooms(@PathVariable("ROOM_NAME") String roomName) {
        List<RoomDTO> list = reservationService.getRooms(roomName);
        return list;
    }
}
