package com.example.hotel_arcana.login.controller;

import com.example.hotel_arcana.login.dto.MemberDTO;
import com.example.hotel_arcana.login.service.MemberService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Log4j2
public class MemberController {

    @Autowired
    private MemberService memberService;

    //회원만 쓸 수 있어서 로그인이 필요한 페이지에 넣기
    //@PreAuthorize("isAuthenticated()")
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("member");
        return "/join";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute MemberDTO memberDTO) {
        log.info(memberDTO);
        memberService.insertMember(memberDTO);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "/login";
    }


//    @PreAuthorize("isAuthenticated()")
    @GetMapping("/login/memberRead/{USER_ID}")
    public String read(@PathVariable String USER_ID, Model model) {
        MemberDTO memberDTO = memberService.memberRead(USER_ID);
        model.addAttribute("memberDTO", memberDTO);
        return "login/memberRead";
    }


    //    @PreAuthorize("isAuthenticated()")
    @GetMapping("/login/memberModify/{USER_ID}")
    public String modify(@PathVariable String USER_ID, Model model) {
        MemberDTO memberDTO = memberService.memberRead(USER_ID);
        model.addAttribute("memberDTO", memberDTO);
        return "login/memberModify";
    }


    //    @PreAuthorize("isAuthenticated()")
    @PostMapping("/login/memberModify")
    public String update(MemberDTO memberDTO) {
        memberService.updateMember(memberDTO);
        return "redirect:login/memberRead/" + memberDTO.getUSER_ID(); // 수정 후 상세 조회 페이지로 리다이렉트
    }


    @GetMapping("/login/memberRemove/{USER_ID}")
    public String deleteMember(@PathVariable("USER_ID") String USER_ID, Model model) {
        memberService.deleteMember(USER_ID);
        return "redirect:/join"; // 삭제 후 리다이렉트할 페이지 설정
    }
}

