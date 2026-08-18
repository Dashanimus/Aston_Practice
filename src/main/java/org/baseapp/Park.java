package org.baseapp;

public class Park {

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
}
