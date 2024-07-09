package com.example.hotel_arcana.memberQna.service;

import com.example.hotel_arcana.memberQna.dto.HotelQnaImgDTO;
import com.example.hotel_arcana.memberQna.dto.MemberQnaDTO;

public interface MemberQnaService {

    Long register(MemberQnaDTO memberQnaDTO);
    void registerImg(HotelQnaImgDTO hotelQnaImgDTO);
}
