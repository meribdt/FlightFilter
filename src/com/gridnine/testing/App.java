package com.gridnine.testing;

import java.util.List;

import com.gridnine.testing.Model.Flight;
import com.gridnine.testing.Service.FlightBuilder;
import com.gridnine.testing.Service.FlightFilter;

public class App {
    public static void main(String[] args) throws Exception {
        var allFlights = FlightBuilder.createFlights();
        print("All flights", FlightFilter.filterFlights(allFlights));
    }

    private static void print(String title, List<Flight> flights) {
        System.out.println(String.format("%s: %d\r\n%s", title, flights.size(), flights));
        System.out.println("****************");
    }
}
