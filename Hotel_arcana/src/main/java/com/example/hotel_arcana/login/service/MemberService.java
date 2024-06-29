package com.example.hotel_arcana.login.service;

import com.example.hotel_arcana.login.dto.MemberDTO;
import com.example.hotel_arcana.security.dto.MemberSecurityDTO;

import java.util.List;
import java.util.stream.Collectors;

public interface MemberService {
    static class IdExistException extends Exception {
    }

    MemberDTO findMemberById(String USER_ID);
    void insertMember(MemberDTO memberDTO);
    MemberDTO memberRead(String USER_ID);
    void updateMember(MemberDTO memberDTO);
//    MemberDTO selectMember(String USER_ID);

}
