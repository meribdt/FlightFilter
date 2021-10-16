package com.gridnine.testing.Filter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.gridnine.testing.Model.Flight;

public class DepartureNotBefore implements FlightFilterInterface {

    private LocalDateTime refDep;

    public DepartureNotBefore(LocalDateTime dep) {
        this.refDep = dep;
    }

    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
            .filter(f -> !refDep.isAfter(f.getSegments().stream()
            .reduce((s1,s2) -> s2.getDepartureDate().isAfter(s1.getDepartureDate()) ? s1 : s2).get().getDepartureDate()))
            .collect(Collectors.toList());
    }    
    
}
