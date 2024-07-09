package com.example.hotel_arcana.notice.service;

import com.example.hotel_arcana.notice.dto.NoticeDTO;
import com.example.hotel_arcana.notice.dto.PageRequestDTO;
import com.example.hotel_arcana.notice.dto.PageResponseDTO;

import java.util.List;

public interface NoticeService {

    List<NoticeDTO> getAll();

    Long register(NoticeDTO noticeDTO);

    NoticeDTO readOne(Long N_NO);

    void delete(Long N_NO);

    void modify(NoticeDTO noticeDTO);

    void increaseViewCount(Long N_NO);

    PageResponseDTO<NoticeDTO> getList(PageRequestDTO pageRequestDTO);
}
