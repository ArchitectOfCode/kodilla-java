package com.kodilla.good.patterns.challenges.smallFlightCompany;

import java.time.LocalDateTime;
import java.util.Objects;

public class Flight {
    private String departureAirport;
    private String arrivalAirport;
    private LocalDateTime departureDateTime;
    private LocalDateTime arrivalDateTime;

    public Flight(String departureAirport, String arrivalAirport, LocalDateTime departureDateTime, LocalDateTime arrivalDateTime) {
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.departureDateTime = departureDateTime;
        this.arrivalDateTime = arrivalDateTime;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public LocalDateTime getDepartureDateTime() {
        return departureDateTime;
    }

    public LocalDateTime getArrivalDateTime() {
        return arrivalDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return departureAirport.equals(flight.departureAirport) &&
                arrivalAirport.equals(flight.arrivalAirport) &&
                departureDateTime.equals(flight.departureDateTime) &&
                arrivalDateTime.equals(flight.arrivalDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departureAirport, arrivalAirport, departureDateTime, arrivalDateTime);
    }

    @Override
    public String toString() {
        return "Flight from " + departureAirport +
                " to " + arrivalAirport +
                " on " + departureDateTime +
                " [arrival time: " + arrivalDateTime + "]";
    }
}
