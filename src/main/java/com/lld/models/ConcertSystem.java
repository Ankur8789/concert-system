package com.lld.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.lld.services.ConcertServices;
import com.lld.services.PaymentService;
import com.lld.services.serviceimpl.PaymentServiceImpl;

public class ConcertSystem implements ConcertServices{

    // singleton class
    private static final ConcertSystem concertSystem = new ConcertSystem();

    // db's
    private HashMap<String, Artist> artistMap;
    private HashMap<String, Booking> bookingMap;
    private HashMap<String, Concert> concertMap;
    private HashMap<String, Stadium> stadiumMap;
    private HashMap<String, Venue> venueMap;

    // Paymemt processor
    private PaymentService paymentService;

    // factories
    private NotificationFactory notificationFactory;

    private ConcertSystem(){
        this.artistMap = new HashMap<>();
        this.bookingMap = new HashMap<>();
        this.concertMap = new HashMap<>();
        this.stadiumMap = new HashMap<>();
        this.venueMap = new HashMap<>();
        this.paymentService = new PaymentServiceImpl();
    }

    // helper
    public static ConcertSystem getInstance(){
        return concertSystem;
    }

	@Override
	public List<Concert> viewConcerts() {
		return new ArrayList<>(concertMap.values());
	}

	@Override
	public List<Concert> searchConcerts(Artist artist, Venue venue, LocalDateTime date) {
        List<Concert> concerts = new ArrayList<>();
        System.out.println("Concerts Based on your filters");
		for(Concert concert : this.concertMap.values()){
            if(concert.getArtist().equals(artist) && concert.getVenue().equals(venue) && concert.getDate().equals(date)){
                concerts.add(concert);
            }
        }
        return concerts;
	}

	@Override
	public Booking bookSeat(Concert concert, Seat seat, NotificationType type) {
		Booking booking = new Booking(concert, seat);
        try{
            synchronized(seat){
                 if(!seat.getSeatStatus().equals(SeatStatus.Available)){
                    System.out.println("Seat has already been Booked, Please try a diff seat !!!");
                    throw new Exception();
                 }
                 seat.setSeatStatus(SeatStatus.InProcess);
                 double amount = seat.getSeat().getSeatType().equals(SeatType.Exclusive) ? 1000.0 : 500.0;
                 paymentService.pay(amount);
                 seat.setSeatStatus(SeatStatus.Booked);
                 booking.setStatus(BookingStatus.Booked);
                 String message = "Booked Ticket for "+ seat + " for Concert " + concert;
                 this.notificationFactory.getInstance(type).notify(message);
            }
        }catch(Exception e){
            booking.setStatus(BookingStatus.Cancelled);
            seat.setSeatStatus(SeatStatus.Available);
        }
        this.bookingMap.put(booking.getId(), booking);
        return booking;
	}

	@Override
	public Artist createArtist(String name, String desc) {
		Artist artist = new Artist(name, desc);
        this.artistMap.put(artist.getId(), artist);
        return artist;
	}

	@Override
	public Concert createConcert(Artist artist, LocalDateTime date, Venue venue) {
		Concert concert = new Concert(artist, date, venue);
        this.concertMap.put(concert.getId(), concert);
        return concert;
	}

	@Override
	public Stadium createStadium() {
		Stadium stadium = new Stadium();
        this.stadiumMap.put(stadium.getId(), stadium);
        return stadium;
	}

	@Override
	public Venue createVenue(Stadium stadium) {
		Venue venue = new Venue(stadium);
        this.venueMap.put(venue.getId(), venue);
        return venue;
	}
    
}
