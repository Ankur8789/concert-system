package com.lld.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;


@Getter 
@Setter 
public class Stadium {
    private String id;
    private List<StadiumSeat> stadiumSeats;

    public Stadium(){
        this.id = UUID.randomUUID().toString();
        this.stadiumSeats = new ArrayList<>();
    }

    public void addSeat(SeatType seatType){
        StadiumSeat seat = new StadiumSeat(seatType);
        this.stadiumSeats.add(seat);
        System.out.println("Seat added successfully");
    }

    public void removeSeat(StadiumSeat seat){
        this.stadiumSeats.remove(seat);
        System.out.println("Removed Seat successfully");
    }
}
