package com.demo.pattern.flyweight;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RailwayTicket implements Ticket {

    private final String type;
    private int fare;
    private String name;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setFare(int fare) {
        this.fare = fare;
    }

    @Override
    public void printTicket() {
        System.out.println("--------TICKET--------");
        System.out.println("Name : "+ name + "\nTicket Type : "
                + type + "\nFare : " + fare);
    }
}
