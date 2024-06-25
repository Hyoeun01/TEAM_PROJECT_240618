package com.example.hotel_arcana.login.service;

import com.example.hotel_arcana.login.dto.MemberDTO;
import com.example.hotel_arcana.login.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberMapper memberMapper;


    private final PasswordEncoder passwordEncoder;


    @Override
    public MemberDTO findMemberById(String USER_ID){
        return memberMapper.findMemberById(USER_ID);
    }

    @Override
    public void insertMember(MemberDTO memberDTO)  {

        memberDTO.setUSER_PW(passwordEncoder.encode(memberDTO.getUSER_PW()));
        memberMapper.insertMember(memberDTO);
    }
}
