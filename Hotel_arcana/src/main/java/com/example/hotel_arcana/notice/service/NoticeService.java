package com.example.hotel_arcana.notice.service;

import com.example.hotel_arcana.notice.dto.NoticeDTO;

import java.util.List;

public interface NoticeService {

    List<NoticeDTO> getAll();
    void register(NoticeDTO noticeDTO);
}