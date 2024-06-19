package com.example.hotel_arcana.notice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NoticeDTO {


    private Long N_NO;
    private String N_TITLE;
    private String N_CONTENT;
    private String N_WRITER;
    private String VIEW;
    private LocalDateTime N_DATE;

}
