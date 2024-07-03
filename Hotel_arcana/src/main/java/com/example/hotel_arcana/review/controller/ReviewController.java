package com.example.hotel_arcana.review.controller;

import com.example.hotel_arcana.review.dto.ReviewDTO;
import com.example.hotel_arcana.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/list")
    public String getAllReviews(Model model) {
        List<ReviewDTO> reviewList = reviewService.getAllReviews();
        model.addAttribute("reviews", reviewList);
        model.addAttribute("newReview", new ReviewDTO()); // 새 리뷰를 입력할 폼을 위한 객체 추가
        return "review/list";
    }

//    @GetMapping("/{id}")
//    @ResponseBody
//    public Optional<ReviewDTO> getReviewById(@PathVariable Long id) {
//        return reviewService.getReviewById(id);
//    }

    @PostMapping
    @ResponseBody
    public String addReview(ReviewDTO reviewDTO) {
        Long RE_ID = reviewDTO.
    }

    @PutMapping("/{id}")
    public String updateReview(@PathVariable Long id, @RequestBody ReviewDTO reviewDTO) {
        reviewDTO.setRE_ID(id);
        reviewService.updateReview(reviewDTO);
        return "redirect:/review/list";
    }

    @DeleteMapping("/{id}")
    public String deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return "redirect:/review/list";
    }
}
