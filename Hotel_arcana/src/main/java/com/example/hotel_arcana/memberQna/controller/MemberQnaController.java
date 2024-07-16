package com.example.hotel_arcana.memberQna.controller;

import com.example.hotel_arcana.memberQna.dto.HotelQnaImgDTO;
import com.example.hotel_arcana.memberQna.dto.MemberQnaDTO;
import com.example.hotel_arcana.memberQna.service.MemberQnaService;
import com.example.hotel_arcana.memberQna.service.MemberQnaServiceImpl;
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
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/memberQna")
@Log4j2
@RequiredArgsConstructor
public class MemberQnaController {

    private final MemberQnaService memberQnaService;
    private final MemberQnaServiceImpl memberQnaServiceImpl;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/register")
    public void getQna() {
    }

    //    @PreAuthorize("principal.username == #MemberQnaDTO.Q_USER_ID")
    @PostMapping("/register")
    public String postQna(Principal principal, @Valid MemberQnaDTO memberQnaDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes, List<MultipartFile> files) throws IOException {

        memberQnaDTO.setQ_USER_ID(principal.getName());
        Long Q_NO = memberQnaService.register(memberQnaDTO);

        // if 이미지가 없을시 null로 저장
        if(files.isEmpty()) {
            log.info("File is empty");

        } else {
            Long ord = 0L;
            for(MultipartFile file : files){
                //실제 파일 이름 출력
                log.info(file.getOriginalFilename());
                //파일의 크기
                log.info(file.getSize());
                //파일의 확장자
                log.info(file.getContentType());
                String uuid = UUID.randomUUID().toString();
                String fileName = file.getOriginalFilename();
                //파일을 저장하는 메서드 : new File("파일을 저장할 경로//파일이름.확장자")
                file.transferTo(new File("c://files//" +uuid+"_"+fileName));
                HotelQnaImgDTO dto = new HotelQnaImgDTO();
                dto.setQ_NO(Q_NO);
                dto.setFilename(fileName);
                dto.setUuid(uuid);
                dto.setOrd(ord);
                ord++;
                // 이미지 DB에 저장
                memberQnaServiceImpl.registerImg(dto);
            }
        }
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/memberQna/register";
        }


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
