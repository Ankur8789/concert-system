package com.lld.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;


@Getter 
@Setter 
public class Venue {
    private String id;
    private Stadium stadium;
    private List<Seat> concertSeats;

    public Venue(Stadium stadium){
        this.id = UUID.randomUUID().toString();
        this.stadium = stadium;
        this.concertSeats = new ArrayList<>();
        for(StadiumSeat stadiumSeat: stadium.getStadiumSeats()){
            Seat seat = new Seat(stadiumSeat);
            this.concertSeats.add(seat);
        }
    }

}
