package org.example.classes;

public class Ticket {
    Attraction _attraction;


    public Ticket(Attraction attraction) {
        _attraction = attraction;
    }

    public Attraction get_attraction() {
        return _attraction;
    }


}
