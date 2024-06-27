package com.example.hotel_arcana.managerQna.mapper;

import com.example.hotel_arcana.managerQna.dto.ManagerQnaDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ManagerQnaMapper {

    List<ManagerQnaDTO> selectAll();

    ManagerQnaDTO selectOne(Long Q_NO);
}
