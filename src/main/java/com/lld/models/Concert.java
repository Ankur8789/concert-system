package com.lld.models;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;


@Getter 
@Setter 
public class Concert {
    private String id;
    private Artist artist;
    private LocalDateTime date;
    private Venue venue;

    public Concert(Artist artist, LocalDateTime date, Venue venue){
        this.id = UUID.randomUUID().toString();
        this.artist = artist;
        this.date = date;
        this.venue = venue;
    }
}
