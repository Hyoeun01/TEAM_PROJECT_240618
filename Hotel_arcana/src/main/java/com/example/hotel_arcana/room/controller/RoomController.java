package com.example.hotel_arcana.room.controller;

import com.example.hotel_arcana.room.dto.RoomDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@Log4j2
@RequiredArgsConstructor
public class RoomController {
    public void getRooms(Model model){
        List<RoomDTO> roomList = new ArrayList<>();

        // 방 이름이 "standard"인 호실만 필터링
        List<RoomDTO> standardRooms = roomList.stream()
                .filter(room -> "standard".equals(room.getROOM_NAME()))
                .collect(Collectors.toList());

        // 방 이름이 "deluxe"인 호실만 필터링
        List<RoomDTO> deluxeRooms = roomList.stream()
                .filter(room -> "deluxe".equals(room.getROOM_NAME()))
                .collect(Collectors.toList());

        List<RoomDTO> loyalDeluxeRooms = roomList.stream()
                .filter(room -> "loyal deluxe".equals(room.getROOM_NAME()))
                .collect(Collectors.toList());
        List<RoomDTO> vipRooms = roomList.stream()
                .filter(room -> "vip".equals(room.getROOM_NAME()))
                .collect(Collectors.toList());
        List<RoomDTO> vvipRooms = roomList.stream()
                .filter(room -> "vvip".equals(room.getROOM_NAME()))
                .collect(Collectors.toList());
        List<RoomDTO> suiteRooms = roomList.stream()
                .filter(room -> "suite".equals(room.getROOM_NAME()))
                .collect(Collectors.toList());

        model.addAttribute("standardRooms", standardRooms);
        model.addAttribute("deluxeRooms", deluxeRooms);
        model.addAttribute("loyalDeluxeRooms", loyalDeluxeRooms);
        model.addAttribute("vipRooms", vipRooms);
        model.addAttribute("vvipRooms", vvipRooms);
        model.addAttribute("suiteRooms", suiteRooms);
        model.addAttribute("roomList", roomList);
    }

}
