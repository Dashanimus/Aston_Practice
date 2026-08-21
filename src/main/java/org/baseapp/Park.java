package org.baseapp;

import java.util.ArrayList;
import java.util.List;

public class Park {
    private String parkName;
    private String parkLocation;
    private String openingTime;
    private String closingTime;
    private List<Attraction> attractions;

    public Park(String parkName, String parkLocation, String openingTime, String closingTime) {
        this.parkName = parkName;
        this.parkLocation = parkLocation;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.attractions = new ArrayList<>();
    }

    public class Attraction {
        private String attractionName;
        private String workingHours;
        private int ticketPrice;

    public Attraction(String attractionName, String workingHours, int ticketPrice) {
        this.attractionName = attractionName;
        this.workingHours = workingHours;
        this.ticketPrice = ticketPrice;
    }
    }

    public void addAttraction(String attractionName, String workingHours, int ticketPrice) {
        Attraction newAttraction = new Attraction(attractionName, workingHours, ticketPrice);
        this.attractions.add(newAttraction);
    }
}
