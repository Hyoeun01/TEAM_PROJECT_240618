package com.example.hotel_arcana.login.service;

import com.example.hotel_arcana.login.dto.MemberDTO;
import com.example.hotel_arcana.login.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
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

    @Override
    public void updateMember(MemberDTO memberDTO) {

        if (memberDTO.getUSER_PW() == null || (memberDTO.getUSER_PW().isEmpty())){
            throw new IllegalArgumentException("Password cannot be null or empty");
        }

        memberDTO.setUSER_PW (passwordEncoder.encode(memberDTO.getUSER_PW()));
        memberMapper.updateMember(memberDTO);
    }


    @Override
    public MemberDTO memberRead(String USER_ID){
        return memberMapper.findMemberById(USER_ID);
        }

    @Override
    public void deleteMember(String USER_ID) {
        memberMapper.deleteMemberById(USER_ID);
    }

    @Override
    public int getTotalMembersCount() {
        return memberMapper.getTotalMembersCount();
    }

    @Override
    public List<MemberDTO> getAllMembers() {
        return memberMapper.findAllMembers();
    }

}
