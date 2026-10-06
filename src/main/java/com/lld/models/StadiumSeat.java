package com.lld.models;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;


@Getter 
@Setter 
public class StadiumSeat {
    private String id;
    private SeatType seatType;

    public StadiumSeat(SeatType type){
        this.id = UUID.randomUUID().toString();
        this.seatType = type;
    }
}
