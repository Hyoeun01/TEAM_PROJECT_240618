package com.example.hotel_arcana.notice.mapper;

import com.example.hotel_arcana.notice.dto.NoticeDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface NoticeMapper {

    List<NoticeDTO> selectAll();

    void insert(NoticeDTO noticeDTO);

    NoticeDTO selectOne(Long N_NO);

    void delete(Long N_NO);

    void update(NoticeDTO noticeDTO);

    void ViewCount(@Param("N_NO") Long N_NO, @Param("N_VIEW") Long N_VIEW);

//    List<NoticeDTO> NoticePage(@Param("offset") int offset, @Param("size") int size);
//
//    Integer NoticeCount();

    List<NoticeDTO> NoticePage(@Param("offset") int offset, @Param("size") int size, @Param("type") String type, @Param("keyword") String keyword);
    Integer NoticeCount(@Param("type") String type, @Param("keyword") String keyword);

}
