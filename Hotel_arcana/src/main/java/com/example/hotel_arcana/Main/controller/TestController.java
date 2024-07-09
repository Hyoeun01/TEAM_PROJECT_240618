package com.example.hotel_arcana.Main.controller;

import com.example.hotel_arcana.Main.service.MainService;
import com.example.hotel_arcana.Main.service.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class TestController {

    @Autowired
    private MainService mainService;

    @GetMapping("/")
    public String showRooms(Model model) {

        List<String> roomNames = Arrays.asList("STANDARD", "DELUXE", "SUPERIOR", "VIP", "VVIP", "SUITE");
        for (String roomName : roomNames) {
            Room room = mainService.getRoom(roomName);
            model.addAttribute(roomName, room);
        }
        return "Main";
    }
//    @GetMapping("/room/{ROOM_NAME}")
    @GetMapping("/room/STANDARD")
    public String showStandardRoom(Model model) {
        Room standardRoom = mainService.getRoomByName("STANDARD");
        model.addAttribute("STANDARD", standardRoom);
        return "/ROOM/STANDARD";
    }
    @GetMapping("/room/DELUXE")
    public String showDELUXERoom(Model model) {
        Room DELUXERoom = mainService.getRoomByName("DELUXE");
        model.addAttribute("DELUXE", DELUXERoom);
        return "/ROOM/DELUXE";
    }
    @GetMapping("/room/VVIP")
    public String showVVIPRoom(Model model) {
        Room VVIPRoom = mainService.getRoomByName("VVIP");
        model.addAttribute("VVIP", VVIPRoom);
        return "/ROOM/VVIP";
    }
    @GetMapping("/room/VIP")
    public String showVipRoom(Model model) {
        Room vipRoom = mainService.getRoomByName("VIP");
        model.addAttribute("VIP", vipRoom);
        return "/ROOM/VIP";
    }
    @GetMapping("/room/SUPERIOR")
    public String showSUPERIORRoom(Model model) {
        Room SUPERIORRoom = mainService.getRoomByName("SUPERIOR");
        model.addAttribute("SUPERIOR", SUPERIORRoom);
        return "/ROOM/SUPERIOR";
    }
    @GetMapping("/room/SUITE")
    public String showSUITERoom(Model model) {
        Room SUITERoom = mainService.getRoomByName("SUITE");
        model.addAttribute("SUITE", SUITERoom);
        return "/ROOM/SUITE";
    }
}
