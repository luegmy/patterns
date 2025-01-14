package com.demo.pattern.flyweight;

import java.util.HashMap;
import java.util.Map;

public class TicketFactory {
    private static Map<String, Ticket> ticketMap = new HashMap<>();

    public static Ticket getTicket(String type, String name, int fare){
        Ticket ticket;
        if(ticketMap.containsKey(type)){
            ticket = ticketMap.get(type);
            System.out.println("entro ya existe tipo");
        } else {
            ticket = new RailwayTicket(type);
            ticketMap.put(type, ticket);
            System.out.println("entro no existe tipo");
        }

        ticket.setName(name);
        ticket.setFare(fare);

        return ticket;
    }
}
