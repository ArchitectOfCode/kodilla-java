package com.kodilla.exception.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlightSearcher {
    private Map<String, Boolean> airports = new HashMap<String, Boolean>();
    private List<Flight> flights = new ArrayList<Flight>();

    public static void main(String[] args) throws RouteNotFoundException{
        FlightSearcher flightSearcher = new FlightSearcher();
        flightSearcher.setAirportsAndFlights();

        for(Flight flight : flightSearcher.flights) {
            System.out.println(flightSearcher.findFlight(flight));
        }
    }

    public void setAirportsAndFlights() {
        // initialize airports map
        airports.put("Newark", true);
        airports.put("Warsaw", true);
        airports.put("Berlin", true);
        airports.put("San Escobar", false);
        airports.put("Beijing", true);
        airports.put("Barcelona", true);
        airports.put("Tey Aviv", false);
        airports.put("Poznan", true);

        // initialize flights map
        flights.add(new Flight("Newark", "Warsaw"));
        flights.add(new Flight("Newark", "San Escobar"));
        flights.add(new Flight("San Escobar", "Beijing"));
        flights.add(new Flight("San Escobar", "Tey Aviv"));
        flights.add(new Flight("Poznan", "Barcelona"));
    }

    String findFlight(Flight flight) throws RouteNotFoundException {
        if(flights.contains(flight)) {
            String message;
            if(airports.get(flight.departureAirport) && airports.get(flight.arrivalAirport)) {
                message = flight.toString() + " is possible";
                return message;
            } else {
                message = flight.toString() + " is not possible because ";
                message += airports.get(flight.departureAirport) != true && airports.get(flight.arrivalAirport) == true ? "departure airport does not exist." : "";
                message += airports.get(flight.departureAirport) != true && airports.get(flight.arrivalAirport) == false ? "departure airport does not exist and " : "";
                message += airports.get(flight.arrivalAirport) != true ? "arrival airport does not exist." : "";
                throw new RouteNotFoundException(message);
            }
        } else {
            return "Flight has been not found.";
        }
    }
}
