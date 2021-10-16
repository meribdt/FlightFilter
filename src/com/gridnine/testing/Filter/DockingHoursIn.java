package com.gridnine.testing.Filter;

import java.util.List;
import java.util.stream.Collectors;

import com.gridnine.testing.CustomCollector.SegmentDockingCollector;
import com.gridnine.testing.Model.Flight;

public class DockingHoursIn implements FlightFilterInterface {

    private long minDocking;
    private long maxDocking;

    public DockingHoursIn(long min, long max) {
        minDocking = min;
        maxDocking = max;
    }

    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
            .filter(f -> f.getSegments().stream()
            .sorted()
            .collect(SegmentDockingCollector.collector(minDocking * 3600, maxDocking * 3600)) == 0)
            .collect(Collectors.toList());
    }  
      
}
