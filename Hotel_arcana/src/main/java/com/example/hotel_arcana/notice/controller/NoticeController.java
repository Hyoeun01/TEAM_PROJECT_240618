package com.example.hotel_arcana.notice.controller;

import com.example.hotel_arcana.notice.dto.NoticeDTO;
import com.example.hotel_arcana.notice.dto.PageRequestDTO;
import com.example.hotel_arcana.notice.dto.PageResponseDTO;
import com.example.hotel_arcana.notice.service.NoticeService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/notice")
@Log4j2
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService noticeService;

    @GetMapping("/list")
    public String getNotices(Model model, PageRequestDTO pageRequestDTO) {
        PageResponseDTO<NoticeDTO> responseDTO = noticeService.getList(pageRequestDTO);
        model.addAttribute("list", responseDTO.getDtoList());
        model.addAttribute("responseDTO", responseDTO);
        model.addAttribute("pageRequestDTO", pageRequestDTO);
        return "/notice/list";
    }

    @GetMapping("/register")
    public void registerGET(Model model){
        model.addAttribute("noticeDTO", new NoticeDTO());
    }

    @PostMapping("/register")
    public String PostNotice(NoticeDTO noticeDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()) {

            // 실패 원인 찾는 코드
            bindingResult.getAllErrors().forEach(error -> log.error("Validation error: {}", error.getDefaultMessage()));

            redirectAttributes.addFlashAttribute("error", bindingResult.getAllErrors());
            log.info("실패");

            return "redirect:/notice/register";
        }

        Long N_NO = noticeService.register(noticeDTO);
        redirectAttributes.addFlashAttribute("result", N_NO);
        log.info("noticeDTO");
        return "redirect:/notice/list";
    }

    @GetMapping("/read")
    public void read(@RequestParam("N_NO") Long N_NO, Model model) {
        noticeService.increaseViewCount(N_NO); // 조회수 증가 메서드 호출
        NoticeDTO noticeDTO = noticeService.readOne(N_NO);
        model.addAttribute("notice", noticeDTO);
    }

//    @PreAuthorize("principal.username == #noticeDTO.N_WRITER")
    @PostMapping("/delete")
    public String delete(NoticeDTO noticeDTO, RedirectAttributes redirectAttributes) {
        Long N_NO = noticeDTO.getN_NO();
        noticeService.delete(N_NO);
        return "redirect:/notice/list";
    }

    @GetMapping("/modify")
    public String GetModify(Long N_NO, Model model) {
        NoticeDTO noticeDTO = noticeService.readOne(N_NO);
        model.addAttribute("notice", noticeDTO);
    return "/notice/modify";
    }

//    @PreAuthorize("principal.username == #noticeDTO.N_WRITER")
    @PostMapping("/modify")
    public String PostModify(NoticeDTO noticeDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if(bindingResult.hasErrors()) {

            // 실패 원인 찾는 코드
            bindingResult.getAllErrors().forEach(error -> log.error("Validation error: {}", error.getDefaultMessage()));

            redirectAttributes.addFlashAttribute("error", bindingResult.getAllErrors());
            log.info("수정 실패");

            return "redirect:/notice/modify";
        }

        noticeService.modify(noticeDTO);
        redirectAttributes.addAttribute("N_NO", noticeDTO.getN_NO());
        return "redirect:/notice/list";
    }

}
