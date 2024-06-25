package com.example.hotel_arcana.login.service;

import com.example.hotel_arcana.login.dto.MemberDTO;

public interface MemberService {
    MemberDTO findMemberById(String user_id);
    void insertMember(MemberDTO memberDTO);
}
