package com.lld.models;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;


@Getter 
@Setter 
public class Seat {
    private String id;
    private StadiumSeat seat;
    private SeatStatus seatStatus;

    public Seat(StadiumSeat seat){
        this.id = UUID.randomUUID().toString();
        this.seat = seat;
        this.seatStatus = SeatStatus.Available;
    }
}
