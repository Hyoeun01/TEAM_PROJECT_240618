package com.example.hotel_arcana.managerQna.controller;

import com.example.hotel_arcana.managerQna.dto.ManagerQnaDTO;
import com.example.hotel_arcana.managerQna.service.ManagerQnaService;
import com.example.hotel_arcana.notice.dto.NoticeDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/managerQna")
@Log4j2
@RequiredArgsConstructor
public class ManagerQnaController {
    private final ManagerQnaService managerQnaService;
    private ManagerQnaDTO managerQnaDTO;

    @GetMapping("/list")
    public String list(Model model) {
        List<ManagerQnaDTO> managerList = managerQnaService.getAll();
        model.addAttribute("managerList", managerList);
        return "managerQna/list";
    }

    @GetMapping("/read")
    public void read(@RequestParam("Q_NO") Long Q_NO, Model model) {
        ManagerQnaDTO managerQnaDTO = managerQnaService.readOne(Q_NO);
        model.addAttribute("managerQna", managerQnaDTO);
    }
}
