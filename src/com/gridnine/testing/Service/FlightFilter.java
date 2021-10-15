package com.gridnine.testing.Service;

import java.util.List;

import com.gridnine.testing.Filter.FlightFilterInterface;
import com.gridnine.testing.Model.Flight;

public class FlightFilter {
    public static List<Flight> filterFlights(List<Flight> flights, FlightFilterInterface... filters) {
        for (FlightFilterInterface f : filters) {
            flights = f.filter(flights);
        }
        return flights;
    }
}
