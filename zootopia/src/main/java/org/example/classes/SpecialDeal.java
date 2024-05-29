package org.example.classes;

public class SpecialDeal implements applyDiscount{

    private final int discount;

    private final int noOfTickets;


    public SpecialDeal(int discount, int noOfTickets) {
        this.discount = discount;
        this.noOfTickets = noOfTickets;
    }

    public int getDiscount() {
        return discount;
    }

    public int getNoOfTickets() {
        return noOfTickets;
    }

    @Override
    public Double apply(Double basevalue)
    {
        return basevalue - ((basevalue * discount) / 100);
    }


}
