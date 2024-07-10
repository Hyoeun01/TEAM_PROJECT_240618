package com.example.hotel_arcana.reservation.controller;

import com.example.hotel_arcana.reservation.dto.ReservationDTO;
import com.example.hotel_arcana.reservation.service.ReservationService;
import com.example.hotel_arcana.room.dto.RoomDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;


@Controller
@RequestMapping("/reservation")
@Log4j2
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;



    @GetMapping("/list")
    public void getReservation(@Valid ReservationDTO reservationDTO, Principal principal,Model model) {
        reservationDTO.setRV_USER_ID(principal.getName());
        List<ReservationDTO> reservationList = reservationService.selectAllbyId(reservationDTO.getRV_USER_ID());
        model.addAttribute("list", reservationList);
    }

    @PreAuthorize("isAuthenticated()")
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


    @PreAuthorize("isAuthenticated()")
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
            return "/reservation/roomchoice";
        }
        log.info(reservationDTO);

        RoomDTO roomDTO = reservationService.getRoom(reservationDTO.getRV_ROOM_NUMBER());

        Long diff = ChronoUnit.DAYS.between(reservationDTO.getSTART_DATE(), reservationDTO.getEND_DATE());
        Long cost = roomDTO.getROOM_PRICE() * diff;
        model.addAttribute("diff", diff);
        model.addAttribute("cost", cost);

        model.addAttribute("reservationInfo",reservationDTO);
        model.addAttribute("roomDTO", roomDTO);

        return "/reservation/preview";
    }

    @GetMapping("/preview")
    public String preview(@Valid ReservationDTO reservationDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes
            , @RequestParam("inDates") String inDates, @RequestParam("outDates") String outDates, @RequestParam("guests") String guests, @PathVariable("ROOM_NAME") String roomName , Model model){

        int TOTAL_NUM = Integer.parseInt(guests);

        reservationDTO.setSTART_DATE(LocalDate.parse(inDates));  // inDates를 LocalDate로 변환
        reservationDTO.setEND_DATE(LocalDate.parse(outDates));// outDates를 LocalDate로 변환
        reservationDTO.setTOTAL_NUM(TOTAL_NUM);


        if (bindingResult.hasErrors()) {
            log.info("에러발생");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "/reservation/roomchoice";
        }
        log.info(reservationDTO);
//        Long RV_ID = reservationService.register(reservationDTO);
        RoomDTO roomDTO = reservationService.getRoom(reservationDTO.getRV_ROOM_NUMBER());
//        redirectAttributes.addFlashAttribute("result", RV_ID);
        model.addAttribute("reservationInfo",reservationDTO);
        model.addAttribute("roomDTO", roomDTO);


        return "/reservation/preview";
    }

    @PostMapping("/preview")
    public String previewPost(Principal principal, @Valid ReservationDTO reservationDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes
            , @RequestParam("inDates") String inDates, @RequestParam("outDates") String outDates, @RequestParam("guests") String guests, Model model){
        int TOTAL_NUM = Integer.parseInt(guests);

        reservationDTO.setSTART_DATE(LocalDate.parse(inDates));  // inDates를 LocalDate로 변환
        reservationDTO.setEND_DATE(LocalDate.parse(outDates));// outDates를 LocalDate로 변환
        reservationDTO.setTOTAL_NUM(TOTAL_NUM);
        reservationDTO.setRV_USER_ID(principal.getName());
        if (bindingResult.hasErrors()) {
            log.info("에러발생");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "/reservation/roomchoice";
        }
        log.info(reservationDTO);

        Long RV_ID = reservationService.register(reservationDTO);
        RoomDTO roomDTO = reservationService.getRoom(reservationDTO.getRV_ROOM_NUMBER());
        redirectAttributes.addFlashAttribute("result", RV_ID);
        return "redirect:/";
    }

    @GetMapping("/read")
    public String read(Long RV_ID, Model model) {
        ReservationDTO reservationDTO = reservationService.getOne(RV_ID);
        RoomDTO roomDTO = reservationService.getRoom(reservationDTO.getRV_ROOM_NUMBER());
        Long diff = ChronoUnit.DAYS.between(reservationDTO.getSTART_DATE(), reservationDTO.getEND_DATE());
        Long cost = roomDTO.getROOM_PRICE() * diff;
        model.addAttribute("diff", diff);
        model.addAttribute("cost", cost);
        model.addAttribute("reservationDTO", reservationDTO);
        model.addAttribute("roomDTO", roomDTO);
        model.addAttribute("RV_ID",RV_ID);

        return "/reservation/read";
    }

    @GetMapping("/modify")
    public String modify(Long RV_ID, Model model) {

        ReservationDTO reservationDTO = reservationService.getOne(RV_ID);
        RoomDTO roomDTO = reservationService.getRoom(reservationDTO.getRV_ROOM_NUMBER());

        model.addAttribute("reservationDTO", reservationDTO);
        model.addAttribute("roomDTO", roomDTO);


        return "/reservation/modify";
    }

    @GetMapping("/remove/{RV_ID}")
    public String remove(@PathVariable("RV_ID") Long RV_ID){
        reservationService.remove(RV_ID);
        return "redirect:/reservation/list";
    }

    @PostMapping("/modify")
    public String modify(@Valid ReservationDTO reservationDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes, @RequestParam("inDates") String inDates, @RequestParam("outDates") String outDates, @RequestParam("guests") String guests,Model model, Long RV_ID) {
        int TOTAL_NUM = Integer.parseInt(guests);

        reservationDTO.setSTART_DATE(LocalDate.parse(inDates));  // inDates를 LocalDate로 변환
        reservationDTO.setEND_DATE(LocalDate.parse(outDates));// outDates를 LocalDate로 변환
        reservationDTO.setTOTAL_NUM(TOTAL_NUM);
        reservationDTO.setRV_ID(RV_ID);


        if(bindingResult.hasErrors()) {
            log.info("에러발생");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
        }

        reservationService.modify(reservationDTO);
//        reservationService.getOne(reservationDTO.getRV_ID());
        RoomDTO roomDTO = reservationService.getRoom(reservationDTO.getRV_ROOM_NUMBER());
        model.addAttribute("reservationDTO", reservationDTO);
        model.addAttribute("roomDTO", roomDTO);

        redirectAttributes.addFlashAttribute("result", "modify success");

        return "redirect:/reservation/list";
    }



}
