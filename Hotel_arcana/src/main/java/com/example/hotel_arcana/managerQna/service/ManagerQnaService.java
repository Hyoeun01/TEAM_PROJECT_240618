package com.example.hotel_arcana.managerQna.service;

import com.example.hotel_arcana.managerQna.dto.ManagerQnaDTO;
import com.example.hotel_arcana.notice.dto.NoticeDTO;
import com.example.hotel_arcana.notice.dto.PageRequestDTO;
import com.example.hotel_arcana.notice.dto.PageResponseDTO;

import java.util.List;

public interface ManagerQnaService {

    List<ManagerQnaDTO> getAll();

    ManagerQnaDTO readOne(Long Q_NO);

    PageResponseDTO<ManagerQnaDTO> getList(PageRequestDTO pageRequestDTO);
}
