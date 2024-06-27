package com.example.hotel_arcana.memberQna.mapper;

import com.example.hotel_arcana.memberQna.dto.MemberQnaDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberQnaMapper {

    void insert(MemberQnaDTO memberQnaDTO);
}
