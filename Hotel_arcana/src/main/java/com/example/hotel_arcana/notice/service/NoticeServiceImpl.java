package com.example.hotel_arcana.notice.service;

import com.example.hotel_arcana.notice.dto.NoticeDTO;
import com.example.hotel_arcana.notice.mapper.NoticeMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Log4j2
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService {

    private final NoticeMapper noticeMapper;

    private NoticeDTO noticeDTO;

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

    @Override
    public void delete(Long N_NO) {
        noticeMapper.delete(N_NO);
    }

    @Override
    public void modify(NoticeDTO noticeDTO) {
        noticeMapper.update(noticeDTO);
    }

    @Override
    public void increaseViewCount(Long N_NO) {
        // 조회수를 가져와서 1 증가시킨 후 업데이트합니다.
        NoticeDTO noticeDTO = noticeMapper.selectOne(N_NO);
        if (noticeDTO != null) {
            long newViewCount = noticeDTO.getN_VIEW() + 1;
            noticeMapper.ViewCount(N_NO, newViewCount);
        }
    }
}
