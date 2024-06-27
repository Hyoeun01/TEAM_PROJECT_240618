package com.example.hotel_arcana.login.service;

import com.example.hotel_arcana.login.dto.MemberDTO;

import java.util.List;

public interface MemberService {
    static class IdExistException extends Exception {
    }

    MemberDTO findMemberById(String USER_ID);
    void insertMember(MemberDTO memberDTO);
//    MemberDTO selectMember(String USER_ID);
//    void updateMember(MemberDTO memberDTO);
    MemberDTO memberRead(String USER_ID);

}
