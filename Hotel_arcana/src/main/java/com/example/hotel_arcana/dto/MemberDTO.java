package com.example.hotel_arcana.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class memberDTO {
    private String user_id;
    private String user_pw;
    private String user_nm;
    private String user_adr;
    private String user_eml;
    private String user_tel;
    private String user_nik;
}
