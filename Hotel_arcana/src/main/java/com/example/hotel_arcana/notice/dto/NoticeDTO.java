package com.example.hotel_arcana.notice.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@ToString
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NoticeDTO {

    private Long N_NO;
    @NotEmpty(message = "제목은 필수 항목입니다.")
    private String N_TITLE;
    @NotEmpty(message = "내용은 필수 항목입니다.")
    private String N_CONTENT;
    @NotEmpty(message = "작성자는 필수 항목입니다.")
    private String N_WRITER;

    @Builder.Default
    @NotNull
    private Long N_VIEW = 0L;

    // 디폴트 표현식 current_timestamp()
    // dateTime 형식
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime N_DATE;

}
