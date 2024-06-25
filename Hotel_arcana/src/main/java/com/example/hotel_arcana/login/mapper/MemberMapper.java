package com.example.hotel_arcana.login.mapper;
import org.apache.ibatis.annotations.Mapper;
import com.example.hotel_arcana.login.dto.MemberDTO;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MemberMapper {
    MemberDTO findMemberById(String user_id);
    void insertMember(MemberDTO memberDTO);
}
