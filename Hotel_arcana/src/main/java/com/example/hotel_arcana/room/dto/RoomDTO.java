package com.example.hotel_arcana.room.dto;

import lombok.*;

@ToString
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoomDTO {

    private Long ROOM_ID;
    private String ROOM_NAME;

    private int ROOM_PRICE;
    private String ROOM_LIMIT;
}
