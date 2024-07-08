package com.example.hotel_arcana.managerQna.mapper;

import com.example.hotel_arcana.managerQna.dto.ManagerQnaDTO;
import com.example.hotel_arcana.notice.dto.NoticeDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ManagerQnaMapper {

    List<ManagerQnaDTO> selectAll();

    ManagerQnaDTO selectOne(Long Q_NO);

    List<ManagerQnaDTO> QnaPage(@Param("offset") int offset, @Param("size") int size, @Param("type") String type, @Param("keyword") String keyword);

    Integer QnaCount(@Param("type") String type, @Param("keyword") String keyword);
}
