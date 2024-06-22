package com.example.hotel_arcana.notice.controller;

import com.example.hotel_arcana.notice.dto.NoticeDTO;
import com.example.hotel_arcana.notice.service.NoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/notice")
@Log4j2
@RequiredArgsConstructor
public class NoticeController {
    private final NoticeService noticeService;
    @GetMapping("/")
    public String getNotices(Model model) {
        model.addAttribute("list",noticeService.getAll());
        return "/notice/list";
    }
//    @PostMapping("/add")
//    public String addNotice(NoticeDTO noticeDTO) {
//        noticeService.register(noticeDTO);
//        return "redirect:/";
//    }

}
