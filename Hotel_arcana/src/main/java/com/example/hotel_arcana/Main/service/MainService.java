package com.example.hotel_arcana.Main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

@Service
public class MainService {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MainService(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    // 모든 방 정보를 조회하는 메서드
    public List<Room> getAllRooms() {
        String sql = "SELECT * FROM room";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Room.class));
    }

    public Room getRoomByName(String roomName) {
        String sql = "SELECT * FROM room WHERE ROOM_NAME = ? LIMIT 1";
        return jdbcTemplate.queryForObject(sql, new Object[]{roomName}, (rs, rowNum) -> {
            Room room = new Room();
            room.setROOM_ID(rs.getLong("ROOM_ID"));
            room.setROOM_NAME(rs.getString("ROOM_NAME"));
            room.setROOM_PRICE(rs.getInt("ROOM_PRICE"));
            room.setROOM_LIMIT(rs.getString("ROOM_LIMIT"));
            return room;
        });
    }
    public Room getRoom(String roomName) {
        String sql = "SELECT * FROM room WHERE ROOM_NAME = ? LIMIT 1";
        return jdbcTemplate.queryForObject(sql, new Object[]{roomName}, BeanPropertyRowMapper.newInstance(Room.class));
    }


}
