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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
    public String postQna(@Valid MemberQnaDTO memberQnaDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes, MultipartFile file) throws IOException {

        //실제 파일 이름 출력
        log.info(file.getOriginalFilename());
        //파일의 크기
        log.info(file.getSize());
        //파일의 확장자
        log.info(file.getContentType());
        //파일을 저장하는 메서드 : new File("파일을 저장할 경로//파일이름.확장자")
        file.transferTo(new File("c://files//" + file.getOriginalFilename()));

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/memberQna/register";
        }

        // 이미지 DB에 저장
        memberQnaDTO.setQ_IMG(file.getOriginalFilename());

        Long Q_NO = memberQnaService.register(memberQnaDTO);
        redirectAttributes.addFlashAttribute("result", Q_NO);

        return "redirect:/managerQna/list";
    }

//    @PreAuthorize("principal.username == #MemberQnaDTO.Q_USER_ID")
//@PostMapping("/register")
//public String postQna(@Valid MemberQnaDTO memberQnaDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes, List<MultipartFile> files) throws IOException {
//
//    final List<MemberQnaDTO> list = new ArrayList<>();
//
//    if (bindingResult.hasErrors()) {
//        redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
//        return "redirect:/memberQna/register";
//    }
//
//    List<String> fileNames = new ArrayList<>();
//    for (MultipartFile file : files) {
//        if (!file.isEmpty()) {
//            // 파일 정보 로그 출력
//            log.info(file.getOriginalFilename());
//            log.info(file.getSize());
//            log.info(file.getContentType());
//
//            // 파일 저장
//            String savePath = "c://files//" + file.getOriginalFilename();
//            file.transferTo(new File(savePath));
//
//            // 파일 이름 저장
//            fileNames.add(file.getOriginalFilename());
//        }
//    }
//
//    // 여러 이미지 파일 이름을 DTO에 저장 (예: 파일 이름들을 콤마로 구분된 문자열로 저장)
//    memberQnaDTO.setQ_IMG(String.join(",", fileNames));
//
//    Long Q_NO = memberQnaService.register(memberQnaDTO);
//    redirectAttributes.addFlashAttribute("result", Q_NO);
//
//    return "redirect:/managerQna/list";
//}

}
