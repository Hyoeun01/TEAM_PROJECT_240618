package com.example.hotel_arcana.reservation.mapper;


import com.example.hotel_arcana.reservation.dto.ReservationDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReservationMapper {

    Long insert(ReservationDTO reservationDTO);
    List<ReservationDTO> selectAll();
    ReservationDTO selectOne(Long RV_ID);
    void update(ReservationDTO reservationDTO);
    void delete(Long RV_ID);
}
