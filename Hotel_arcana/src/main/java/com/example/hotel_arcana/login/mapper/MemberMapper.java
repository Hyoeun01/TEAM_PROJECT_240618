package com.example.hotel_arcana.login.mapper;

import com.example.hotel_arcana.login.dto.MemberDTO;

public interface MemberMapper {
    MemberDTO findMemberById(String user_id);
    void insertMember(MemberDTO memberDTO);
}
