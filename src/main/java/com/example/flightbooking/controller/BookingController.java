package com.example.flightbooking.controller;

import com.example.flightbooking.dto.BookFlightRequest;
import com.example.flightbooking.service.BookingService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public ResponseEntity<String> bookFlight(@Valid @RequestBody BookFlightRequest request) {
        String response = bookingService.bookFlight(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}