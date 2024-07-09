package com.example.hotel_arcana.review.service;

import com.example.hotel_arcana.review.dto.ReviewDTO;
import com.example.hotel_arcana.review.dto.PageRequestDTO;
import com.example.hotel_arcana.review.dto.PageResponseDTO;
import com.example.hotel_arcana.review.mapper.ReviewMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Log4j2
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewMapper reviewMapper;
    private ReviewDTO reviewDTO;

//    private List<ReviewDTO> reviewList = new ArrayList<>();

    @Override
    public List<ReviewDTO> getAllReviews() {
        return reviewMapper.selectAll();
    }

//    @Override
//    public List<ReviewDTO> getAllReviews() {
//        List<ReviewDTO> reviewList = reviewMapper.selectAll();
//        return reviewList;
//    }

    @Override
    public Optional<ReviewDTO> getReviewById(Long id) {
        return Optional.ofNullable(reviewMapper.selectById(id));
    }

    @Override
    public Long addReview(ReviewDTO reviewDTO) {
        reviewMapper.insert(reviewDTO);

        return reviewDTO.getRE_ID();
    }

}
