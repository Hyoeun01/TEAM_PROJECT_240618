package com.example.hotel_arcana.memberQna.controller;

import com.example.hotel_arcana.memberQna.dto.MemberQnaDTO;
import com.example.hotel_arcana.memberQna.service.MemberQnaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/memberQna")
@Log4j2
@RequiredArgsConstructor
public class MemberQnaController {

    private final MemberQnaService memberQnaService;

    @GetMapping("/register")
    public void getQna() {}

//    @PreAuthorize("principal.username == #MemberQnaDTO.Q_USER_ID")
    @PostMapping("/register")
    public String postQna(@Valid MemberQnaDTO memberQnaDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        log.info("dddddd");

        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(error -> log.error("Validation error: {}", error.getDefaultMessage()));
            log.info("에러발생");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "/register";
        }

        Long Q_NO = memberQnaService.register(memberQnaDTO);
        redirectAttributes.addFlashAttribute("result", Q_NO);

        return "redirect:/notice/list";
    }

}
