package com.example.hotel_arcana.managerQna.service;

import com.example.hotel_arcana.managerQna.dto.ManagerQnaDTO;
import com.example.hotel_arcana.managerQna.mapper.ManagerQnaMapper;
import com.example.hotel_arcana.managerQna.dto.PageRequestDTO;
import com.example.hotel_arcana.managerQna.dto.PageResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class ManagerQnaServiceImpl implements ManagerQnaService {

    private final ManagerQnaMapper managerQnaMapper;

    @Override
    public List<ManagerQnaDTO> getAll() {
        List<ManagerQnaDTO> managerQnaList =  managerQnaMapper.selectAll();

        return managerQnaList;
    }

    @Override
    public ManagerQnaDTO readOne(Long Q_NO) {

        return managerQnaMapper.selectOne(Q_NO);
    }

    @Override
    public PageResponseDTO<ManagerQnaDTO> getList(PageRequestDTO pageRequestDTO) {
        // 페이지에 따른 오프셋 계산
        int offset = (pageRequestDTO.getPage() - 1) * pageRequestDTO.getSize();

        // 데이터베이스에서 QnA 리스트 조회
        List<ManagerQnaDTO> dtoList = managerQnaMapper.QnaPage(offset, pageRequestDTO.getSize(), pageRequestDTO.getType(), pageRequestDTO.getKeyword(), pageRequestDTO.getQ_BOX());

        // 데이터베이스에서 QnA 총 개수 조회
        Integer count = managerQnaMapper.QnaCount(pageRequestDTO.getType(), pageRequestDTO.getKeyword(),pageRequestDTO.getQ_BOX());

        // 총 개수 설정
        int total = count != null ? count : 0;

        // PageResponseDTO 생성 및 반환
        return new PageResponseDTO<>(pageRequestDTO, dtoList, total);
    }

}
