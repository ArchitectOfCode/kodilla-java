package com.kodilla.good.patterns.challenges.smallFlightCompany;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class SmallFlightCompanyTestSuite {
    public Set<Flight> testTimetable() {
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

    @Test
    public void testNumberOfFlights() {
        //Given
        FlightCompany trialFlights = new FlightCompany();
        //When
        int resultFlightTableLength = trialFlights.getTimetable().toArray().length;

        //Then
        Assert.assertEquals(13, resultFlightTableLength);
    }

    @Test
    public void testNumberOfFlightsFromPoznan() {
        //Given
        FlightCompany trialFlights = new FlightCompany();
        //When
        int resultFlightTableLength = trialFlights.getFlightsFrom(trialFlights.getTimetable(), "Poznań").toArray().length;

        //Then
        Assert.assertEquals(4, resultFlightTableLength);
    }

    @Test
    public void testFlightsFromPoznan() {
        //Given
        FlightCompany trialFlights = new FlightCompany();
        //When
        String resultFlightsFromPoznan = trialFlights.getFlightsFrom(trialFlights.getTimetable(), "Poznań").toString();
        //Then
        String expectedFlightsFromPoznan = "[Flight from Poznań to Warszawa on 2018-12-29T10:30 [arrival time: 2018-12-29T11:20], " +
                "Flight from Poznań to Warszawa on 2018-12-28T10:30 [arrival time: 2018-12-28T11:20], " +
                "Flight from Poznań to Wrocław on 2018-12-28T19:00 [arrival time: 2018-12-28T19:45], " +
                "Flight from Poznań to Warszawa on 2018-12-30T10:30 [arrival time: 2018-12-30T11:20]]";
        Assert.assertEquals(expectedFlightsFromPoznan, resultFlightsFromPoznan);
    }

    @Test
    public void testFlightsToKrakow() {
        //Given
        FlightCompany trialFlights = new FlightCompany();
        //When
        String resultFlightsToKrakow = trialFlights.getFlightsTo(trialFlights.getTimetable(), "Kraków").toString();
        //Then
        String expectedFlightsToKrakow = "[Flight from Gdańsk to Kraków on 2018-12-28T11:00 [arrival time: 2018-12-28T12:30], " +
                "Flight from Szczecin to Kraków on 2018-12-28T06:30 [arrival time: 2018-12-28T07:48]]";
        Assert.assertEquals(expectedFlightsToKrakow, resultFlightsToKrakow);
    }

    @Test
    public void testCombinedFlights() {
        //Given
        FlightCompany trialFlights = new FlightCompany();
        //When
        String resultCombinedFlightFromPoznanToSzczecin =
                trialFlights.getCombinedFlightsFromTo(trialFlights.getTimetable(), "Poznań",  "Szczecin");
        //Then
        String expectedCombinedFlightsFromPoznanToSzczecin = "Departure from Poznań on 2018-12-29T10:30 " +
                "with transfer in Warszawa [arrival time: 2018-12-29T11:20] " +
                "to Szczecin on 2018-12-29T19:00 [arrival time: 2018-12-29T19:55].\n" +
                "Departure from Poznań on 2018-12-28T10:30 with transfer in Warszawa [arrival time: 2018-12-28T11:20] " +
                "to Szczecin on 2018-12-28T19:00 [arrival time: 2018-12-28T19:55].\n" +
                "Departure from Poznań on 2018-12-28T10:30 with transfer in Warszawa [arrival time: 2018-12-28T11:20] " +
                "to Szczecin on 2018-12-29T19:00 [arrival time: 2018-12-29T19:55].\n";
        Assert.assertEquals(expectedCombinedFlightsFromPoznanToSzczecin, resultCombinedFlightFromPoznanToSzczecin);
    }
}
