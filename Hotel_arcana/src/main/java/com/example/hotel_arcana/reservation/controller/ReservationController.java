package com.example.hotel_arcana.reservation.controller;

import com.example.hotel_arcana.reservation.dto.ReservationDTO;
import com.example.hotel_arcana.reservation.service.ReservationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/reservation")
@Log4j2
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;

    @GetMapping("/list")
    public String getReservation(Model model) {
        List<ReservationDTO> reservationList = reservationService.getAll();
        model.addAttribute("list", reservationList);

        return "/reservation/list";
    }

    @GetMapping("/register")
    public String register(Model model) {
        return "/reservation/register";
    }

    @PostMapping("/register")
    public String register(@Valid ReservationDTO reservationDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "/reservation/register";
        }
        log.info(reservationDTO);
        Long RV_ID = reservationService.register(reservationDTO);
        redirectAttributes.addFlashAttribute("result", RV_ID);
        return "redirect:/reservation/list";
    }

    @GetMapping({"/read","/modify"})
    public void read(Long RV_ID, Model model) {
        ReservationDTO reservationDTO = reservationService.getOne(RV_ID);
        model.addAttribute("dto", reservationDTO);
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
