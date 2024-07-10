package com.example.hotel_arcana.review.controller;

import com.example.hotel_arcana.notice.dto.NoticeDTO;
import com.example.hotel_arcana.reservation.dto.ReservationDTO;
import com.example.hotel_arcana.reservation.service.ReservationService;
import com.example.hotel_arcana.review.dto.ReviewDTO;
import com.example.hotel_arcana.review.service.ReviewService;
import com.example.hotel_arcana.security.dto.MemberSecurityDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/review")
@Log4j2
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;
    private final ReservationService reservationService;



    @GetMapping("/list")
    public String getAllReviews(Principal principal, ReservationDTO reservationDTO, Model model) {
        List<ReviewDTO> reviewList = reviewService.getAllReviews();

//
//        reservationDTO.setRV_USER_ID(principal.getName());
//        ReservationDTO reservation = reservationService.getOne(reservationDTO.getRV_ID());
//        model.addAttribute("reservation", reservation);
        model.addAttribute("reviews", reviewList);

        model.addAttribute("newReview", new ReviewDTO()); // 새 리뷰를 입력할 폼을 위한 객체 추가
        return "review/list";
    }

    @GetMapping("/register")
    public void registerReview( Authentication authentication, ReservationDTO reservationDTO, Model model) {

        MemberSecurityDTO memberSecurityDTO =(MemberSecurityDTO) authentication.getPrincipal();
        reservationDTO.setRV_USER_ID(memberSecurityDTO.getUSER_ID());

        ReservationDTO reservation = reservationService.getOne(reservationDTO.getRV_ID());
//        List<ReservationDTO> reservationList = reservationService.selectAllbyId(reservationDTO.getRV_USER_ID());
        model.addAttribute("reservation", reservation);
//        model.addAttribute("reservation", reservationList);
        model.addAttribute("newReview", new ReviewDTO());
    }


    @PostMapping( "/register")
    public String addReview( Authentication authentication,ReviewDTO reviewDTO, RedirectAttributes redirectAttributes, MultipartFile file,
                            BindingResult bindingResult) throws IOException {

        //사진이없어도 게시글 업로드
        if (!file.isEmpty()) {
            //실제 파일 이름 출력
            log.info(file.getOriginalFilename());
            //파일의 크기
            log.info(file.getSize());
            //파일의 확장자
            log.info(file.getContentType());
            //파일을 저장하는 메서드 : new File("파일을 저장할 경로//파일이름.확장자")
            file.transferTo(new File("c://files//" + file.getOriginalFilename()));
            reviewDTO.setRE_IMG(file.getOriginalFilename());
        } else {
            log.info("No file uploaded");
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/review/list";
        }

        MemberSecurityDTO memberSecurityDTO =(MemberSecurityDTO) authentication.getPrincipal();

        reviewDTO.setRE_USER_ID(memberSecurityDTO.getUSER_ID());
        reviewDTO.setRE_WRITER(memberSecurityDTO.getUSER_NIK());
        Long RE_ID = reviewService.addReview(reviewDTO);
        redirectAttributes.addAttribute("id", RE_ID);


        return "redirect:/review/list";

//      실제 파일 이름 출력
//        log.info(file.getOriginalFilename());
//        //파일의 크기
//        log.info(file.getSize());
//        //파일의 확장자
//        log.info(file.getContentType());
//        //파일을 저장하는 메서드 : new File("파일을 저장할 경로//파일이름.확장자")
//        file.transferTo(new File("c://files//" + file.getOriginalFilename()));
//
//        if (bindingResult.hasErrors()) {
//            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
//            return "redirect:/review/list";
//        }
//
//        reviewDTO.setRE_IMG(file.getOriginalFilename());
//
//        Long RE_ID = reviewService.addReview(reviewDTO);
//        redirectAttributes.addAttribute("id", RE_ID);

//        return "redirect:/review/list";

    }

//    @PutMapping("/{id}")
//    public String updateReview(@PathVariable Long id, @RequestBody ReviewDTO reviewDTO) {
//        reviewDTO.setRE_ID(id);
//        reviewService.updateReview(reviewDTO);
//        return "redirect:/review/list";
//    }
//
//    @DeleteMapping("/{id}")
//    public String deleteReview(@PathVariable Long id) {
//        reviewService.deleteReview(id);
//        return "redirect:/review/list";
//    }

    @PostMapping
    public String createReview() {
        // 리뷰 생성 로직을 여기에 구현
        return "redirect:/review/list"; // 리뷰 생성 후 리다이렉트할 URL
    }
}
