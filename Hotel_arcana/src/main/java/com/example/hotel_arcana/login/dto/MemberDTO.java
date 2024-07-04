package com.example.hotel_arcana.login.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Builder
@Data
@Getter
@Setter
public class MemberDTO {

    @NotBlank(message = "아이디를 입력해주세요.")
    private String USER_ID;
    @NotBlank(message = "비밀번호를 입력해주세요.")
    private String USER_PW;
    @NotBlank(message = "이름을 입력해주세요.")
    private String USER_NM;
    @NotBlank(message = "주소를 입력해주세요.")
    private String USER_ADR;
    @NotBlank(message = "이메일을 입력해주세요.")
    private String USER_EML;
    @NotBlank(message = "전화번호를 입력해주세요.")
    private String USER_TEL;
    @NotBlank(message = "닉네임을 입력해주세요.")
    private String USER_NIK;
    private String USER_AUTH;

    public boolean isEmpty() {
        return this.USER_ID.isEmpty();

    }

}
