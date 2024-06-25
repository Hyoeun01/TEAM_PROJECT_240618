package com.example.hotel_arcana.login.mapper;
import org.apache.ibatis.annotations.Mapper;
import com.example.hotel_arcana.login.dto.MemberDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MemberMapper {
    MemberDTO findMemberById(String USER_ID);
    void insertMember(MemberDTO memberDTO);
}
