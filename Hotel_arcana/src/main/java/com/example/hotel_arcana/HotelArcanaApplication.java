package com.example.hotel_arcana;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@MapperScan("com.example.*")
//@MapperScan("com.example.hotel_arcana.notice.mapper")
@SpringBootApplication
@MapperScan("com.example.hotel_arcana.login.mapper")
public class HotelArcanaApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelArcanaApplication.class, args);
    }

}
