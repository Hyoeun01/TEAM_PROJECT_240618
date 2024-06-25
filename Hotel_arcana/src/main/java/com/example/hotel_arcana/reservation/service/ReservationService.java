package com.example.hotel_arcana.reservation.service;

import com.example.hotel_arcana.reservation.dto.ReservationDTO;

import java.util.List;

public interface ReservationService {

    void register(ReservationDTO reservationDTO);
    List<ReservationDTO> getAll();
    ReservationDTO getOne(String RV_ID);
    void remove(String RV_ID);
    void modify(ReservationDTO reservationDTO);
}
