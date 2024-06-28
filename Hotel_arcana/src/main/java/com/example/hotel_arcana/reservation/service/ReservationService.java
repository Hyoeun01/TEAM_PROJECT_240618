package com.example.hotel_arcana.reservation.service;

import com.example.hotel_arcana.reservation.dto.ReservationDTO;
import com.example.hotel_arcana.room.dto.RoomDTO;

import java.util.List;

public interface ReservationService {

    Long register(ReservationDTO reservationDTO);
    List<ReservationDTO> getAll();
    ReservationDTO getOne(Long RV_ID);
    void remove(Long RV_ID);
    void modify(ReservationDTO reservationDTO)
            ;
    List<RoomDTO> getRooms();
}
