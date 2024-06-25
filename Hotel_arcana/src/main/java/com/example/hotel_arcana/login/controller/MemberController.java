package com.example.hotel_arcana.login.controller;

import com.example.hotel_arcana.login.dto.MemberDTO;
import com.example.hotel_arcana.login.service.MemberService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Log4j2
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("member", new MemberDTO());
        return "join";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute MemberDTO memberDTO) {
        log.info(memberDTO);
        memberService.insertMember(memberDTO);
        return "redirect:/index";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }
}
