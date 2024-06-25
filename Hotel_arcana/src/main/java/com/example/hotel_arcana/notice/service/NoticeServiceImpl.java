package com.example.hotel_arcana.notice.service;

import com.example.hotel_arcana.notice.dto.NoticeDTO;
import com.example.hotel_arcana.notice.mapper.NoticeMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService {

    private final NoticeMapper noticeMapper;
    private NoticeDTO noticeDTO;

//    @Override
//    public String getTime() {
//        String time = NoticeMapper.getTime();
//        return time;
//    }

    @Override
    public List<NoticeDTO> getAll() {
        List<NoticeDTO> noticeList = noticeMapper.selectAll();
        return noticeList;
    }

    @Override
    public Long register(NoticeDTO noticeDTO) {
        noticeMapper.insert(noticeDTO);

        return noticeDTO.getN_NO();
    }

    @Override
    public NoticeDTO readOne(Long N_NO) {

        return noticeMapper.selectOne(N_NO);
    }
}
