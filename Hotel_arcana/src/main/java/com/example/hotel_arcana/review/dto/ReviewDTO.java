package com.example.hotel_arcana.review.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@ToString
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDTO {

    private Long RE_ID;
    private String RE_WRITER;
    private String RE_CONTENT;

    // 디폴트 표현식 current_timestamp()
    // dateTime 형식
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDate RE_DATE;
    private String RE_IMG;
    private String RE_USER_ID;

}
