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

//    @PostMapping("/login")
//    public String userLogin(String USER_ID, String USER_PW) {
//        MemberDTO memberDTO = memberService.findMemberById(USER_ID);
//        if (memberDTO != null && memberDTO.getUSER_PW().equals(USER_PW)) {
//            log.info(USER_ID);
//            return "redirect:/index";
//        }else {
//            log.info("실패");
//            return "login";
//        }
//    }

//    @GetMapping("/modify")
//    public String modify(String USER_ID, Model model) {
//        MemberDTO memberDTO = MemberService.selectMember(USER_ID);
//        model.addAttribute("USER_ID", USER_ID);
//        return "modify";
//    }
//
//    @PostMapping("/modify")
//    public String modify(MemberDTO memberDTO) {
//        MemberService.updateMember(memberDTO);
//        return "redirect:/index";
//    }
@GetMapping("/login/memberRead")
public void getMemberRead(@RequestParam("USER_ID") String USER_ID, Model model) {
    MemberDTO memberDTO = memberService.memberRead(USER_ID);
    model.addAttribute("member", memberDTO);

}
}

