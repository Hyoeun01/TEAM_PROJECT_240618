package com.example.hotel_arcana.Main.service;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ROOM_ID;

    private String ROOM_NAME;
    private int ROOM_PRICE;
    private String ROOM_LIMIT;

    // 기본 생성자
    public Room() {
    }

    // 생성자
    public Room(String roomName, int roomPrice, String roomLimit) {
        this.ROOM_NAME = roomName;
        this.ROOM_PRICE = roomPrice;
        this.ROOM_LIMIT = roomLimit;
    }

    // Getter and Setter methods
    public Long getROOM_ID() {
        return ROOM_ID;
    }

    public void setROOM_ID(Long ROOM_ID) {
        this.ROOM_ID = ROOM_ID;
    }

    public String getROOM_NAME() {
        return ROOM_NAME;
    }

    public void setROOM_NAME(String ROOM_NAME) {
        this.ROOM_NAME = ROOM_NAME;
    }

    public int getROOM_PRICE() {
        return ROOM_PRICE;
    }

    public void setROOM_PRICE(int ROOM_PRICE) {
        this.ROOM_PRICE = ROOM_PRICE;
    }

    public String getROOM_LIMIT() {
        return ROOM_LIMIT;
    }

    public void setROOM_LIMIT(String ROOM_LIMIT) {
        this.ROOM_LIMIT = ROOM_LIMIT;
    }
}

