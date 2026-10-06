package com.lld.models;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
public class Booking {
    private String id;
    private Concert concert;
    private Seat seat;
    private BookingStatus status;

    public Booking(Concert concert, Seat seat){
        this.id = UUID.randomUUID().toString();
        this.concert = concert;
        this.seat = seat;
        this.status = BookingStatus.InProcess;
    }
}
