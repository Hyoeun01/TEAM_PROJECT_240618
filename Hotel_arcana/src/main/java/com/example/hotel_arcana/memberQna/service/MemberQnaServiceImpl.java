package com.example.hotel_arcana.memberQna.service;

import com.example.hotel_arcana.memberQna.dto.MemberQnaDTO;
import com.example.hotel_arcana.memberQna.mapper.MemberQnaMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class MemberQnaServiceImpl implements MemberQnaService {

    private final MemberQnaMapper memberQnaMapper;

    @Override
    public Long register(MemberQnaDTO memberQnaDTO) {
        log.info("Register memberQnaDTO: " + memberQnaDTO);
        memberQnaMapper.insert(memberQnaDTO);
//        return 1L;
        return memberQnaDTO.getQ_NO();
    }
}
