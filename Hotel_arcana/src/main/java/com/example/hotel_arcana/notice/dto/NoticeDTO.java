package com.example.hotel_arcana.notice.dto;

import lombok.*;

import java.time.LocalDateTime;

@ToString
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NoticeDTO {

    private Long N_NO;
    private String N_TITLE;
    private String N_CONTENT;
    private String N_WRITER;

    private Integer N_VIEW;

    private LocalDateTime N_DATE;

}
