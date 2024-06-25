package com.example.hotel_arcana;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@Log4j2
@ContextConfiguration(locations = "file:/src/main/webapp/mybatis-config.xml")
class HotelArcanaApplicationTests {

    @Test
    void contextLoads() {
    }

}
