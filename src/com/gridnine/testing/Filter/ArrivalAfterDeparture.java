package com.gridnine.testing.Filter;

import java.util.List;
import java.util.stream.Collectors;

import com.gridnine.testing.Model.Flight;

public class ArrivalAfterDeparture implements FlightFilterInterface {

    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
            .filter(f -> f.getSegments().stream()
            .filter(s -> s.getDepartureDate().isAfter(s.getArrivalDate())).count() == 0)
            .collect(Collectors.toList());
    }    
    
}
