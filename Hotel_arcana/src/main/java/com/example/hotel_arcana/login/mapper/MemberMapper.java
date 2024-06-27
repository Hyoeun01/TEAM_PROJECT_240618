package com.example.hotel_arcana.login.mapper;
import org.apache.ibatis.annotations.Mapper;
import com.example.hotel_arcana.login.dto.MemberDTO;

@Mapper
public interface MemberMapper {
    MemberDTO findMemberById(String USER_ID);
    void insertMember(MemberDTO memberDTO);
//    MemberDTO selectMember(String USER_ID);
//    void updateMember(MemberDTO memberDTO);

}
