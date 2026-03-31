package com.example.flightbooking.service;

import com.example.flightbooking.dto.BookFlightRequest;
import com.example.flightbooking.model.Flight;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class BookingService {

    private final Map<String, Flight> flightMap = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {
        flightMap.put("FL100", new Flight("FL100", 100));
        flightMap.put("FL200", new Flight("FL200", 50));
        flightMap.put("FL300", new Flight("FL300", 75));
    }

    public String bookFlight(BookFlightRequest request) {

        Flight flight = flightMap.get(request.getFlightNumber());

        if (flight == null) {
            throw new IllegalArgumentException("Flight not found");
        }

        synchronized (flight) {
            if (flight.getAvailableSeats() < request.getSeatCount()) {
                throw new IllegalStateException("Not enough seats available");
            }
            flight.bookSeats(request.getSeatCount());
        }

        return "Booking successful for " + request.getPassengerName()
                + " on flight " + request.getFlightNumber();
    }
}