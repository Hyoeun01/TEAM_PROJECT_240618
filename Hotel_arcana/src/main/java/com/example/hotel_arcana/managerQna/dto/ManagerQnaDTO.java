package com.example.hotel_arcana.managerQna.dto;

import com.example.hotel_arcana.memberQna.dto.HotelQnaImgDTO;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@ToString
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ManagerQnaDTO {

    private Long Q_NO;
    private String Q_BOX;
    private String Q_MAIL;
    private String Q_PHONE;
    private String Q_TITLE;
    private String Q_CONTENT;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDate Q_DATE;
    private String Q_IMG;
    private String Q_USER_ID;

    private String USER_NIK;
    private List<HotelQnaImgDTO> hotelQnaImgDTOS;


}
