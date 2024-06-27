package com.example.hotel_arcana.reservation.dto;

import lombok.*;

import java.time.LocalDate;

@ToString
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDTO {

    private Long RV_ID;
    private LocalDate START_DATE;
    private LocalDate END_DATE;
    private int TOTAL_NUM;

    private String RV_USER_ID;
    private Long RV_ROOM_NUMBER ;

}
