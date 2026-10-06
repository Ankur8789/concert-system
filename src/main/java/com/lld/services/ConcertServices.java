package com.lld.services;

import java.time.LocalDateTime;
import java.util.List;

import com.lld.models.*;

public interface ConcertServices {
    
    // view avaliable concerts and booking arragements
    public List<Concert> viewConcerts();

    public List<Concert> searchConcerts(Artist artist, Venue venue, LocalDateTime date);

    public Booking bookSeat(Concert concert, Seat seat, NotificationType type);

    public Artist createArtist(String name, String desc);

    public Concert createConcert(Artist artist, LocalDateTime date, Venue venue);

    public Stadium createStadium();

    public Venue createVenue(Stadium stadium);

}
