package com.kodilla.good.patterns.challenges.smallFlightCompany;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

public class FlightCompany {
    public Set<Flight> getTimetable() {
        Set<Flight> flightsTimetable = new HashSet<Flight>();

        flightsTimetable.add(new Flight("Wrocław", "Poznań",
                LocalDateTime.of(2018, 12, 28, 13, 00),
                LocalDateTime.of(2018, 12, 28, 13, 45)));
        flightsTimetable.add(new Flight("Poznań", "Wrocław",
                LocalDateTime.of(2018, 12, 28, 19, 00),
                LocalDateTime.of(2018, 12, 28, 19, 45)));
        flightsTimetable.add(new Flight("Poznań", "Warszawa",
                LocalDateTime.of(2018, 12, 28, 10, 30),
                LocalDateTime.of(2018, 12, 28, 11, 20)));
        flightsTimetable.add(new Flight("Warszawa", "Poznań",
                LocalDateTime.of(2018, 12, 29, 7, 30),
                LocalDateTime.of(2018, 12, 29, 8, 20)));
        flightsTimetable.add(new Flight("Szczecin", "Warszawa",
                LocalDateTime.of(2018, 12, 28, 17, 15),
                LocalDateTime.of(2018, 12, 28, 18, 10)));
        flightsTimetable.add(new Flight("Warszawa", "Szczecin",
                LocalDateTime.of(2018, 12, 28, 19, 00),
                LocalDateTime.of(2018, 12, 28, 19, 55)));
        flightsTimetable.add(new Flight("Kraków", "Szczecin",
                LocalDateTime.of(2018, 12, 28, 20, 00),
                LocalDateTime.of(2018, 12, 28, 21, 18)));
        flightsTimetable.add(new Flight("Szczecin", "Kraków",
                LocalDateTime.of(2018, 12, 28, 6, 30),
                LocalDateTime.of(2018, 12, 28, 7, 48)));
        flightsTimetable.add(new Flight("Gdańsk", "Kraków",
                LocalDateTime.of(2018, 12, 28, 11, 00),
                LocalDateTime.of(2018, 12, 28, 12, 30)));
        flightsTimetable.add(new Flight("Kraków", "Gdańsk",
                LocalDateTime.of(2018, 12, 28, 15, 00),
                LocalDateTime.of(2018, 12, 28, 16, 30)));
        flightsTimetable.add(new Flight("Poznań", "Warszawa",
                LocalDateTime.of(2018, 12, 29, 10, 30),
                LocalDateTime.of(2018, 12, 29, 11, 20)));
        flightsTimetable.add(new Flight("Warszawa", "Szczecin",
                LocalDateTime.of(2018, 12, 29, 19, 00),
                LocalDateTime.of(2018, 12, 29, 19, 55)));
        flightsTimetable.add(new Flight("Poznań", "Warszawa",
                LocalDateTime.of(2018, 12, 30, 10, 30),
                LocalDateTime.of(2018, 12, 30, 11, 20)));
        flightsTimetable.add(new Flight("Poznań", "Warszawa",
                LocalDateTime.of(2018, 12, 30, 10, 30),
                LocalDateTime.of(2018, 12, 30, 11, 20)));

        return flightsTimetable;
    }

    public Set<Flight> getFlightsFrom(Set<Flight> timetable, String airport) {
        return timetable.stream()
                .filter(apt -> apt.getDepartureAirport().equals(airport))
                .collect(Collectors.toSet());
    }

    public Set<Flight> getFlightsTo(Set<Flight> timetable, String airport) {
        return timetable.stream()
                .filter(apt -> apt.getArrivalAirport().equals(airport))
                .collect(Collectors.toSet());
    }

    public void showFlights(Set<Flight> timetable) {
        timetable.stream()
                .forEach(System.out::println);
    }

    public String getCombinedFlightsFromTo(Set<Flight> timetable, String departureAirport, String arrivalAirport) {
        Set<Flight> flightsFrom = getFlightsFrom(timetable, departureAirport);
        Set<Flight> flightsTo = getFlightsTo(timetable, arrivalAirport);
        String combinedFlightsMessage = "";

        for(Flight flightFrom : flightsFrom) {
            for(Flight flightTo : flightsTo) {
                if(flightTo.getDepartureAirport().equals(flightFrom.getArrivalAirport())
                        && flightFrom.getArrivalDateTime().minusMinutes(30).isBefore(flightTo.getDepartureDateTime())) {
                    combinedFlightsMessage = combinedFlightsMessage.concat("Departure from " + flightFrom.getDepartureAirport() + " on " + flightFrom.getDepartureDateTime() +
                            " with transfer in " + flightFrom.getArrivalAirport() + " [arrival time: " + flightFrom.getArrivalDateTime() +
                            "] to " + flightTo.getArrivalAirport() + " on " + flightTo.getDepartureDateTime() +
                            " [arrival time: " + flightTo.getArrivalDateTime() + "].\n");
                }
            }
        }
        return combinedFlightsMessage;
    }

    public static void main(String[] args) {
        FlightCompany polWaffe = new FlightCompany();

        System.out.println("All available flights:");
        polWaffe.showFlights(polWaffe.getTimetable());

        System.out.println("\nFlights from Poznań:");
        polWaffe.showFlights(polWaffe.getFlightsFrom(polWaffe.getTimetable(), "Poznań"));

        System.out.println("\nFlights to Warszawa:");
        polWaffe.showFlights(polWaffe.getFlightsTo(polWaffe.getTimetable(), "Warszawa"));

        System.out.println("\nFlights to Szczecin:");
        polWaffe.showFlights(polWaffe.getFlightsTo(polWaffe.getTimetable(), "Szczecin"));

        System.out.println("\nFlights from Poznań to Szczecin:");
        System.out.println(polWaffe.getCombinedFlightsFromTo(polWaffe.getTimetable(), "Poznań",  "Szczecin"));
    }
}
