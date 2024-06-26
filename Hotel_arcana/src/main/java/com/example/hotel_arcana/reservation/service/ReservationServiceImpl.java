package com.example.hotel_arcana.reservation.service;


import com.example.hotel_arcana.reservation.dto.ReservationDTO;
import com.example.hotel_arcana.reservation.mapper.ReservationMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationMapper reservationMapper;

    @Override
    public Long register(ReservationDTO reservationDTO) {

        Long RV_ID =  reservationMapper.insert(reservationDTO);
        return RV_ID;
    }

    @Override
    public List<ReservationDTO> getAll() {
        List<ReservationDTO> reservationDTO = reservationMapper.selectAll();
        return reservationDTO;
    }

    @Override
    public ReservationDTO getOne(Long RV_ID) {
        ReservationDTO reservationDTO = reservationMapper.selectOne(RV_ID);
        return reservationDTO;
    }

    @Override
    public void remove(String RV_ID) {
        reservationMapper.delete(RV_ID);
    }

    @Override
    public void modify(ReservationDTO reservationDTO) {
        reservationMapper.update(reservationDTO);
    }
}
