package com.example.hotel_arcana.reservation.controller;

import com.example.hotel_arcana.reservation.dto.ReservationDTO;
import com.example.hotel_arcana.reservation.service.ReservationService;
import com.example.hotel_arcana.room.dto.RoomDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;


@Controller
@RequestMapping("/reservation")
@Log4j2
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;

    @GetMapping("/list")
    public void getReservation(Model model) {
        List<ReservationDTO> reservationList = reservationService.getAll();
        model.addAttribute("list", reservationList);
    }

    @GetMapping("/roomchoice")
    public void roomlist(Model model){
        List<RoomDTO> roomDTO =  reservationService.getRoomInfo();

        model.addAttribute("rooms",roomDTO);
    }

    @GetMapping("/register/{ROOM_NAME}")
    public String register(@PathVariable("ROOM_NAME") String roomName, Model model) {
        model.addAttribute("rooms", reservationService.getRooms(roomName));
        model.addAttribute("room_name", roomName);
        log.info("Requested room: " + roomName);

        return "/reservation/register";
    }

    @PostMapping("/register/{ROOM_NAME}")
    public String register(@Valid ReservationDTO reservationDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes
    , @RequestParam("inDates") String inDates, @RequestParam("outDates") String outDates, @RequestParam("guests") String guests, @PathVariable("ROOM_NAME") String roomName , Model model){

        int TOTAL_NUM = Integer.parseInt(guests);

        reservationDTO.setSTART_DATE(LocalDate.parse(inDates));  // inDates를 LocalDate로 변환
        reservationDTO.setEND_DATE(LocalDate.parse(outDates));// outDates를 LocalDate로 변환
        reservationDTO.setTOTAL_NUM(TOTAL_NUM);

        if (bindingResult.hasErrors()) {
            log.info("에러발생");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "/register";
        }
        log.info(reservationDTO);
        Long RV_ID = reservationService.register(reservationDTO);
        RoomDTO roomDTO = reservationService.getRoom(reservationDTO.getRV_ROOM_NUMBER());
        redirectAttributes.addFlashAttribute("result", RV_ID);
        model.addAttribute("reservationInfo",reservationDTO);
        model.addAttribute("roomDTO", roomDTO);
        return "/reservation/preview";
    }

    @GetMapping("/preview")
    public void preview(){

    }

    @GetMapping({"/read","/modify"})
    public String read(Long RV_ID, Model model) {
        ReservationDTO reservationDTO = reservationService.getOne(RV_ID);
        model.addAttribute("dto", reservationDTO);

        return "/reservation/read";
    }

    @PostMapping("/remove")
    public String remove(Long RV_ID, RedirectAttributes redirectAttributes){
        reservationService.remove(RV_ID);
        return "redirect:/reservation/list";
    }

    @PostMapping("/modify")
    public String modify(@Valid ReservationDTO reservationDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        log.info("수정 중"+reservationDTO);

        if(bindingResult.hasErrors()) {
            log.info("에러발생");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
        }

        reservationService.modify(reservationDTO);
        redirectAttributes.addFlashAttribute("result", "modify success");
        redirectAttributes.addAttribute("RV_ID", reservationDTO.getRV_ID());
        return "redirect:/reservation/list";
    }



}
