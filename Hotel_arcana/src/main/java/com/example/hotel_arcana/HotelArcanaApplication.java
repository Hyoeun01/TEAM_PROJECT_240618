package com.example.hotel_arcana;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("com.example.hotel_arcana.login.mapper")
//@MapperScan("com.example.**")
public class HotelArcanaApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelArcanaApplication.class, args);
    }

}
