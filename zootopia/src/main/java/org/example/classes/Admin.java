package org.example.classes;

import java.util.*;


public class Admin extends User{


    private final List<SpecialDeal> _specialDeals;

    private final List<Discount> _discounts;

    List<Visitor> _visitors;

    public Admin() {
        super("admin", "admin123");

        _discounts = new ArrayList<>(Arrays.asList(new Discount(Category.MINOR, 10), new Discount(Category.SENIOR, 20))){};
        _specialDeals = new ArrayList<>(Arrays.asList(new SpecialDeal(15, 2), new SpecialDeal(30,3))){};
        _visitors = new ArrayList<>();

    }

    public List<SpecialDeal> getSpecialDeals() {
        return _specialDeals;
    }

    public List<Discount> getDiscounts() {
        return _discounts;
    }


    public void addVisitor(Visitor visitor) {
        if(_visitors.contains(visitor)){
            System.out.println("Visitor already added");
        }else{
            _visitors.add(visitor);
            System.out.println("Visitor added successfully");
        }
    }

    public Visitor findVisitor(String email){
        for(Visitor vis: _visitors){
            if(Objects.equals(vis.getMail(), email)){
                System.out.println("Visitor found");
                return vis;
            }
        }
        System.out.println("Visitor not found");
        return null;
    }

    @Override
    protected boolean login(String user, String pass) {
        return Objects.equals(user, _name) && Objects.equals(pass, _password);
    }

    public void addDeal(int noOfTickets, int percentage) {
        SpecialDeal newDeal = new SpecialDeal(percentage, noOfTickets);
        _specialDeals.add(newDeal);
        System.out.println("Special deal added successfully.");

    }
    public void removeSpecialDeal(int noOfTickets, int percentage) {
        SpecialDeal dealToRemove = null;
        for (SpecialDeal deal : _specialDeals) {
            if (deal.getNoOfTickets() == noOfTickets && deal.getDiscount() == percentage) {
                dealToRemove = deal;
                break;
            }
        }
        if (dealToRemove != null) {
            _specialDeals.remove(dealToRemove);
            System.out.println("Special deal removed successfully.");
        } else {
            System.out.println("Special deal not found.");
        }
    }
    public void addDiscount(Category category, int discount) {
        Discount newDiscount = new Discount(category, discount);
        _discounts.add(newDiscount);
        System.out.println("Discount added successfully.");
    }

    public void removeDiscount(Category category, double discount) {
        for(Discount discount1: _discounts){
            if(Objects.equals(discount1.getCategory(), category) && discount1.getDiscountPercentage() == discount){
                _discounts.remove(discount1);
                System.out.println("Discount removed successfully.");
                return;
            }
        }
        System.out.println("Discount not found.");
    }

    public void viewDiscount(){

        System.out.println("Discounts: ");
        int i=0;
        for(Discount discount : _discounts){
            i++;
            System.out.println(i + ". "
                    + "Discount category: "+ discount.getCategory() +" and percentage: "+discount.getDiscountPercentage() + "DiscountCode: "+ discount.getDiscountCode());
        }
        System.out.println();
    }

    public void viewDeal(){
        System.out.println("Special Deals: ");
        int i=0;
        for(SpecialDeal deal : _specialDeals){
            i++;
            System.out.println(i + ". Buy "+deal.getNoOfTickets() +" tickets and get "+deal.getDiscount()+"% discount");
        }
        System.out.println();
    }

    private String popularAtt(){
        if (_visitors.isEmpty() || Zoo.get_attractions().isEmpty()) {
            return "There are no visitors or no attractions";
        }
        Map<String, Integer> counts = new HashMap<>();
        for (Visitor visitor : _visitors) {
            for (Ticket ticket : visitor.get_tickets()) {
                Attraction att = ticket.get_attraction();
                String attName = att.getName();
                counts.put(attName, counts.getOrDefault(attName, 0) + 1);
            }
        }
        String popAtt = "";
        int maxcount = 0;

        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            if (entry.getValue() > maxcount) {
                popAtt= entry.getKey();
                maxcount = entry.getValue();
            }
        }return popAtt;

    }

    public void visitorStats(){
        System.out.println("Visitor Statistics:");
        System.out.println("- Total Visitors: "+_visitors.size());
        System.out.println("- Total Revenue: "+Zoo.revenue);
        System.out.println("- Most Popular Attraction: "+popularAtt());

    }

}
