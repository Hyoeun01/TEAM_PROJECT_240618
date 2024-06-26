package com.example.hotel_arcana.notice.mapper;

import com.example.hotel_arcana.notice.dto.NoticeDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {

    List<NoticeDTO> selectAll();

    void insert(NoticeDTO noticeDTO);

    NoticeDTO selectOne(Long N_NO);

    void delete(Long N_NO);

    void update(NoticeDTO noticeDTO);
}
