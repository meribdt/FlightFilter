package com.gridnine.testing.Filter;

import java.util.List;

import com.gridnine.testing.Model.Flight;

public interface FlightFilterInterface {
    public List<Flight> filter(List<Flight> flights);
}
