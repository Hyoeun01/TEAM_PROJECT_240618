package com.example.hotel_arcana.notice.service;

import com.example.hotel_arcana.notice.dto.NoticeDTO;
import com.example.hotel_arcana.notice.mapper.NoticeMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService {

    private final ModelMapper modelMapper;
    private final NoticeMapper noticeMapper;

    @Override
    public List<NoticeDTO> getAll() {
        List<NoticeDTO> noticeList = noticeMapper.selectAll().stream()
                .map(dto -> modelMapper.map( dto,NoticeDTO.class))
                .collect(Collectors.toList());
        return noticeList;
    }

    @Override
    public void register(NoticeDTO noticeDTO) {
        noticeMapper.insert(noticeDTO);
    }
}
