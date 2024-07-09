package com.example.hotel_arcana.memberQna.dto;

import lombok.*;

import java.time.LocalDateTime;

@ToString
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HotelQnaImgDTO {
    private Long qna_img_no;
    private String uuid;
    private String filename;
    private Long ord;
    private Long Q_NO;
    private LocalDateTime regdate;
}
