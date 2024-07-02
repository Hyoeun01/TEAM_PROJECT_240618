package com.example.hotel_arcana.notice.mapper;

import com.example.hotel_arcana.notice.dto.NoticeDTO;
import com.example.hotel_arcana.review.dto.PageRequestDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface NoticeMapper {

    List<NoticeDTO> selectAll();

    void insert(NoticeDTO noticeDTO);

    NoticeDTO selectOne(Long N_NO);

    void delete(Long N_NO);

    void update(NoticeDTO noticeDTO);

    void ViewCount(@Param("N_NO") Long N_NO, @Param("N_VIEW") Long N_VIEW);

    List<NoticeDTO> NoticePage(@Param("offset") int offset, @Param("size") int size);

    Integer NoticeCount();

}
