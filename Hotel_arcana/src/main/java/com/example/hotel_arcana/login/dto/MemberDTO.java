package com.example.hotel_arcana.login.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class MemberDTO {
    private String USER_ID;
    private String USER_PW;
    private String USER_NM;
    private String USER_ADR;
    private String USER_EML;
    private String USER_TEL;
    private String USER_NIK;
}
