package com.example.hotel_arcana.login.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class MemberDTO {
    private String user_id;
    private String user_pw;
    private String user_nm;
    private String user_adr;
    private String user_eml;
    private String user_tel;
    private String user_nik;
}
