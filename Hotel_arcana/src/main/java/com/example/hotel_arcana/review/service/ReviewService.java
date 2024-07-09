package com.example.hotel_arcana.review.service;

import com.example.hotel_arcana.reservation.dto.ReservationDTO;
import com.example.hotel_arcana.review.dto.ReviewDTO;
import com.example.hotel_arcana.review.dto.PageRequestDTO;
import com.example.hotel_arcana.review.dto.PageResponseDTO;

import java.util.List;
import java.util.Optional;

public interface ReviewService {

    List<ReviewDTO> getAllReviews();

    Optional<ReviewDTO> getReviewById(Long id);

    Long addReview(ReviewDTO reviewDTO);

//    void updateReview(ReviewDTO reviewDTO);
//
//    void deleteReview(Long id);

    List<ReservationDTO> selectAllbyId(String RV_USER_ID);


}
