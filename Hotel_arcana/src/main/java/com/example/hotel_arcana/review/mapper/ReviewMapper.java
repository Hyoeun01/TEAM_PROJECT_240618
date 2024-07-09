package com.example.hotel_arcana.review.mapper;

import com.example.hotel_arcana.notice.dto.NoticeDTO;
import com.example.hotel_arcana.review.dto.ReviewDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;

@Mapper
public interface ReviewMapper {

    List<ReviewDTO> selectAll();

    void insert(ReviewDTO reviewDTO);

//    void delete(@Param("RE_ID") Long RE_ID);
//
//    void update(ReviewDTO reviewDTO);

    ReviewDTO selectById(@Param("RE_ID") Long RE_ID);

}
