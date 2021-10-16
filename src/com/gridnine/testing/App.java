package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;

import com.gridnine.testing.Filter.ArrivalAfterDeparture;
import com.gridnine.testing.Filter.DepartureNotBefore;
import com.gridnine.testing.Filter.DockingHoursIn;
import com.gridnine.testing.Model.Flight;
import com.gridnine.testing.Service.FlightBuilder;
import com.gridnine.testing.Service.FlightFilter;

public class App {
    
    public static void main(String[] args) {
        try {
            var allFlights = FlightBuilder.createFlights();
            print("ALL FLIGHTS", FlightFilter.filterFlights(allFlights));
            print("FILTER DEPARTURE IN THE PAST", FlightFilter.filterFlights(allFlights, 
                new DepartureNotBefore(LocalDateTime.now())
            ));
            print("FILTER ARRIVAL BEFORE DEPARTURE", FlightFilter.filterFlights(allFlights, 
                new ArrivalAfterDeparture()
            ));
            print("FILTER DOCKING LONGER THAN 2 HOURS", FlightFilter.filterFlights(allFlights, 
                new DockingHoursIn(0, 2)
            ));
            print("ALL FILTERS", FlightFilter.filterFlights(allFlights, 
                new DepartureNotBefore(LocalDateTime.now()),
                new ArrivalAfterDeparture(),
                new DockingHoursIn(0, 2)
            ));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void print(String title, List<Flight> flights) {
        System.out.println(String.format("%s: %d", title, flights.size()));
        flights.stream().forEach(f -> System.out.println(f));
        System.out.println("\r\n");
    }

}
