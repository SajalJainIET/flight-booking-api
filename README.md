Flight Ticket Booking API

A lightweight Spring Boot REST API for managing flight bookings in-memory. This project was developed as part of a technical assessment, utilizing AI-assisted development and manual refactoring.

Prerequisites
- Java 17 or higher
- Maven 3.6+

Steps

- Clone the repository
- Run using Maven (./mvnw spring-boot:run)
- The server will start on http://localhost:8080

Example Requests:

The system is pre-loaded with the following flights:

- FL100 (100 seats)

- FL200 (50 seats)

- FL300 (75 seats)

Successful Booking

API : POST http://localhost:8080/api/bookings

Body: {
"flightNumber": "FL100",
"passengerName": "John Doe",
"seatCount": 2
}

Failed Booking (Insufficient Seats)

API : POST http://localhost:8080/api/bookings

Body: {
"flightNumber": "FL300",
"passengerName": "Jane Doe",
"seatCount": 100
}

Invalid Request (Validation Error)

API : POST http://localhost:8080/api/bookings

Body: {
"flightNumber": "FL100",
"passengerName": "",
"seatCount": -1
}


What I Would Improve (With More Time)

- Persistence Layer: Replace the ConcurrentHashMap with a real database (e.g., PostgreSQL or H2) using Spring Data JPA to ensure data survives application restarts.

- Distributed Locking: Currently, synchronized blocks handle concurrency on a single instance. In a distributed environment, I would implement a distributed lock using Redis (Redisson) to prevent overbooking across multiple server nodes.

- Comprehensive Testing: Add JUnit 5 and Mockito tests to cover edge cases, specifically focusing on concurrent booking race conditions.

- Logging & Monitoring: Implement SLF4J logging and Spring Boot Actuator for health checks and production monitoring.

- API Versioning: Introduce versioning (e.g., /api/v1/bookings) to ensure backward compatibility for future updates.


