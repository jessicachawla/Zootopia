package org.example.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import static org.example.classes.ExperienceLevel.BASIC;
import static org.example.classes.ExperienceLevel.PREMIUM;


public class Visitor extends User{

    private ExperienceLevel _experienceLevel;

    private Category _category;

    public String getMail() {
        return _mail;
    }

    private final List<Ticket> _tickets;


    private final int _age;
    private final long _phnum;
    private double _balance;
    private final String _mail;



    public Visitor(String _name, int _age, long _phnum, double _balance, String _mail, String _password) {
        super(_name,_password);
        this._age = _age;
        this._phnum = _phnum;
        this._balance = _balance;
        this._mail = _mail;
        this._tickets = new ArrayList<>();
        if (_age < 18) {
            _category = Category.MINOR;
        } else if (_age > 60) {
            _category = Category.SENIOR;
        }
    }

    public double get_balance() {
        return _balance;
    }

    public void set_balance(double _balance) {
        this._balance = _balance;
    }


    public void set_experienceLevel(ExperienceLevel _experienceLevel) {
        this._experienceLevel = _experienceLevel;
    }

    public List<Ticket> get_tickets() {
        return _tickets;
    }

    @Override
    protected boolean login(String mail , String pass) {
        return Objects.equals(mail, _mail) && Objects.equals(pass, _password);
    }

    public void buyMembership(List<Discount> availableDiscounts){

        int choice;
        String dis;
        Scanner scan = new Scanner(System.in);

        System.out.println();
        System.out.println("Buy Membership");
        System.out.println("1. Basic Membership (Rs. 20)");
        System.out.println("2. Premium Membership (Rs. 50)");
        System.out.println();
        System.out.println("Enter your choice: ");
        choice = scan.nextInt();
        System.out.println();
        System.out.println("Apply discount code: ");
        scan.nextLine();
        dis = scan.nextLine();
        double basevalue = -1;
        ExperienceLevel experienceLevel;

        switch(choice){

            case 1->{basevalue = 20.0; experienceLevel=BASIC;}
            case 2->{basevalue = 50.0; experienceLevel=PREMIUM;}
            default -> {System.out.println("Invalid request"); return;}
        }

        double amount=-1;
        for(Discount discount: availableDiscounts){
            if(discount.getDiscountCode().equalsIgnoreCase(dis)) {
                if(discount.getCategory()==_category) {
                    amount = discount.apply(basevalue);
                    System.out.println("Discount applied successfully");
                }
            }
        }
        if (amount == -1) {
            System.out.println("Discount Code Invalid");
        }


        if(get_balance()>=amount){

            set_balance(get_balance()-amount);
            System.out.println(experienceLevel.name() + " Membership bought successfully. Your balance is"+ get_balance());
            set_experienceLevel(experienceLevel);
            Zoo.revenue+=amount;
        }
        else System.out.println("Not enough balance");
    }

    public void buyTicket(List<Attraction> attraction, List<Discount> discounts, List<SpecialDeal> deals) {

        System.out.println("Your balance: " + get_balance());
        System.out.println("Buy Ticket: ");
        System.out.println("Enter number of tickets: ");
        Scanner scan = new Scanner(System.in);
        int totTickets = scan.nextInt();
        int storeTotTickets = totTickets;
        scan.nextLine();
        List<Ticket> selectedTickets = new ArrayList<>();
        double totalAmount = 0;

        System.out.println("Select attraction to buy ticket(one by one if more than one ticket is bought): ");
        while (totTickets > 0) {
            for (int i = 0; i < attraction.size(); i++) {
                System.out.println(i + 1 + ". " + attraction.get(i).toString());
            }

            int ch = scan.nextInt();
            scan.nextLine();

            if (ch > attraction.size() || ch < 1) {
                System.out.println("Invalid choice");
                return;
            }

            Attraction selectedAttraction = attraction.get(ch - 1);

            totalAmount+=selectedAttraction.getTicketPrice();

            System.out.println("Added " + selectedAttraction.getName() + " to cart");
            System.out.println("TotalAmount: " + totalAmount);
            selectedTickets.add(new Ticket(selectedAttraction));
            totTickets--;

        }

        System.out.println("Apply discount code: ");
        String dis = scan.nextLine();
        double basevalue = totalAmount;

        double amount = -1;
        for (Discount discount : discounts) {
            if (discount.getDiscountCode().equalsIgnoreCase(dis)) {
                if(discount.getCategory()==_category) {
                    amount = discount.apply(basevalue);
                    System.out.println("Discount applied successfully");
                    break;
                }else System.out.println("Discount not applicable");
            }
        }
        if (amount == -1) {
            System.out.println("Discount Code Invalid");
            amount = basevalue;
        }


        basevalue = amount;

        double finalamount = -1;
        int specaialDealToApply = -1;
        for (int i=0;i<deals.size();i++) {
            if(deals.get(i).getNoOfTickets()<storeTotTickets){
                specaialDealToApply = i;
            }
        }
        if (specaialDealToApply == -1) {
            System.out.println("No special deal applicable");
            finalamount = basevalue;
        }
        else {
            System.out.println("Special deal applied successfully");
            finalamount = deals.get(specaialDealToApply).apply(basevalue);
        }

        if(finalamount>get_balance()){
            System.out.println("Not enough balance");
        }
        else {
            set_balance(get_balance()-finalamount);
            System.out.println("Tickets bought successfully. Your balance is "+ get_balance());
            Zoo.revenue+=finalamount;
            _tickets.addAll(selectedTickets);
        }

    }

    public void visitAnimal(Animal animal) {

        int choice;
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose the activity: ");
        System.out.println("1. Feed the animal");
        System.out.println("2. Read about the animal");

        System.out.println();
        System.out.println("Enter your choice");
        choice= scan.nextInt();

        switch(choice){
            case 1-> System.out.println(animal.getNoise());
            case 2-> System.out.println(animal.toString());
            default -> System.out.println("Invalid activity");
        }
    }
    private boolean hasTicketForAttraction(Attraction attraction) {
        for (Ticket ticket : _tickets) {
            if (ticket.get_attraction() == attraction) {

                _tickets.remove(ticket);
                System.out.println("1 Ticket Used.");
                return true;
            }
        }
        System.out.println("Basic Members need to buy separate tickets for the attractions.");
        return false;
    }

    public void visitAttraction(Attraction attraction) {
        if (_experienceLevel== PREMIUM){
            System.out.println("Welcome to " + attraction.getName() + ". Enjoy your visit!");
        }else if (_experienceLevel==BASIC){
            if (hasTicketForAttraction(attraction)){
                System.out.println("Welcome to " + attraction.getName() + ". Enjoy your visit!");
            }
        }else System.out.println("You need to buy membership first");

    }



}
