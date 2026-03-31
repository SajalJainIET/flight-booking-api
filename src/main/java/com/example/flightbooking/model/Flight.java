package com.example.flightbooking.model;

public class Flight {

    private String flightNumber;
    private int totalSeats;
    private int availableSeats;

    public Flight(String flightNumber, int totalSeats) {
        this.flightNumber = flightNumber;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void bookSeats(int seats) {
        this.availableSeats -= seats;
    }
}