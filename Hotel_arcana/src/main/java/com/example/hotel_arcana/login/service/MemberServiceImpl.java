package com.example.hotel_arcana.login.service;

import com.example.hotel_arcana.login.dto.MemberDTO;
import com.example.hotel_arcana.login.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
        if(memberDTO.getUSER_AUTH() == null || memberDTO.getUSER_AUTH().isEmpty()){
            memberDTO.setUSER_AUTH("USER");
        }
        memberMapper.insertMember(memberDTO);

    }

//    @Override
//    public MemberDTO selectMember(String USER_ID) {
//        return memberMapper.selectMember(USER_ID);
//    }
//
//    @Override
//    public void updateMember(MemberDTO memberDTO) {
//        return  memberMapper.updateMember(memberDTO);
//    }

    @Override
    public MemberDTO memberRead(String USER_ID){
        return memberMapper.findMemberById(USER_ID);
        }
}
