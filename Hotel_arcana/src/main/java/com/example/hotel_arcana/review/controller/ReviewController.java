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

    @GetMapping("/{id}")
    @ResponseBody
    public Optional<ReviewDTO> getReviewById(@PathVariable Long id) {
        return reviewService.getReviewById(id);
    }

//    @PostMapping
//    public String addReview(@RequestBody ReviewDTO reviewDTO) {
//        reviewService.addReview(reviewDTO);
//        return "redirect:/review/list";
//    }

    @PostMapping
    @ResponseBody
    public Map<String, Object> addReview(@RequestBody ReviewDTO reviewDTO) {
        Map<String, Object> response = new HashMap<>();
        try {
            Long reviewId = reviewService.addReview(reviewDTO);
            reviewDTO.setRE_ID(reviewId);
            response.put("success", true);
            response.put("review", reviewDTO);
        } catch (Exception e) {
            response.put("success", false);
            response.put("error", e.getMessage());
        }
        return response;
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
