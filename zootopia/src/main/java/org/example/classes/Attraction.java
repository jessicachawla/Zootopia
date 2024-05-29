package org.example.classes;

import java.util.List;


public class Attraction{
    public void setStatusOpenOrClosed(boolean statusOpenOrClosed) {
        this.statusOpenOrClosed = statusOpenOrClosed;
    }

    private static int autoid=0;
    private final int id;
     private final String name;

    private String description;

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    private int ticketPrice;

    public int getTicketPrice() {
        return ticketPrice;
    }

    private int countOfTicketedVisitors;

    private boolean statusOpenOrClosed;

    private List<Animal> animals;

    public Attraction(String name, String description, int ticketPrice) {
        autoid++;
        this.id=autoid;
        this.name = name;
        this.description = description;
        this.ticketPrice = ticketPrice;
    }


    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString(){
        return getName() + " (₹" + getTicketPrice() + ")";
    }
}
