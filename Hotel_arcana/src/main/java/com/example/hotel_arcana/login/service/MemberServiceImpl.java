package com.example.hotel_arcana.login.service;

import com.example.hotel_arcana.login.dto.MemberDTO;
import com.example.hotel_arcana.login.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberMapper memberMapper;


    private final PasswordEncoder passwordEncoder;

//    @Autowired
//    public MemberServiceImpl(MemberMapper memberMapper, PasswordEncoder passwordEncoder) {
//        this.memberMapper = memberMapper;
//        this.passwordEncoder = passwordEncoder;
//    }

    @Override
    public MemberDTO findMemberById(String user_id){
        return memberMapper.findMemberById(user_id);
    }

    @Override
    public void insertMember(MemberDTO memberDTO){
        memberDTO.setUser_pw(passwordEncoder.encode(memberDTO.getUser_pw()));
        memberMapper.insertMember(memberDTO);
    }
}
