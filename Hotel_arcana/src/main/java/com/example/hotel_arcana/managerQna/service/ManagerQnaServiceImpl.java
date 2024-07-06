package com.example.hotel_arcana.managerQna.service;

import com.example.hotel_arcana.managerQna.dto.ManagerQnaDTO;
import com.example.hotel_arcana.managerQna.mapper.ManagerQnaMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class ManagerQnaServiceImpl implements ManagerQnaService {

    private final ManagerQnaMapper managerQnaMapper;
    private  ManagerQnaDTO managerQnaDTO;

    @Override
    public List<ManagerQnaDTO> getAll() {
        List<ManagerQnaDTO> managerQnaList =  managerQnaMapper.selectAll();

        return managerQnaList;
    }

    @Override
    public ManagerQnaDTO readOne(Long Q_NO) {

        return managerQnaMapper.selectOne(Q_NO);
    }
}
