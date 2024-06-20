package com.example.hotel_arcana.notice.mapper;

import com.example.hotel_arcana.notice.dto.NoticeDTO;

import java.util.List;

public interface NoticeMapper {
    String getTime();

    List<NoticeDTO> selectAll();

    void insert(NoticeDTO noticeDTO);
}
