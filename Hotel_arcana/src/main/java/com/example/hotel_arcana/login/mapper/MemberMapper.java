package com.example.hotel_arcana.login.mapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import com.example.hotel_arcana.login.dto.MemberDTO;

import java.util.List;

@Mapper
public interface MemberMapper {
    MemberDTO findMemberById(String USER_ID);
    void insertMember(MemberDTO memberDTO);
    void updateMember(MemberDTO memberDTO);
void deleteMemberById(String USER_ID);
}
