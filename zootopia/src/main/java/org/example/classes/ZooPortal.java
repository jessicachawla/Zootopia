package org.example.classes;

import java.util.Scanner;

public class ZooPortal {

    private static final Admin adminUser = new Admin();
    private static final Zoo _zoo = new Zoo();

    public static void main(String[] args) {

        System.out.println("Welcome to the Zoo Portal!");
        System.out.println();

        Scanner scan = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Enter as Admin");
            System.out.println("2. Enter as Visitor");
            System.out.println("3. View Special Deals");
            System.out.println("4. Exit");

            System.out.println("Enter your choice: ");
            choice = scan.nextInt();

            switch (choice) {
                case 1 -> {
                    scan.nextLine();
                    System.out.println("Enter Admin Username: ");
                    String username = scan.nextLine();
                    System.out.println("Enter Admin Password: ");
                    String password = scan.nextLine();
                    if (adminUser.login(username, password)) {
                        System.out.println("Logged in as Admin");
                        adminMenu();
                    } else {
                        System.out.println("Incorrect username or password");
                    }
                }

                case 2 -> {
                    int _choice;
                    do {
                        System.out.println("1. Visitor Register");
                        System.out.println("2. Visitor Login");
                        System.out.println("3. Exit");
                        _choice = scan.nextInt();
                        scan.nextLine();
                        switch (_choice) {
                            case 1 -> {
                                System.out.println("Enter Visitor Name: ");
                                String _name = scan.nextLine();
                                System.out.println("Enter Visitor Age: ");
                                int _age = scan.nextInt();
                                System.out.println("Enter Visitor Phone number: ");
                                long _phnum = scan.nextLong();
                                System.out.println("Enter Visitor Balance: ");
                                double _bal = scan.nextDouble();
                                scan.nextLine();
                                System.out.println("Enter Visitor Email: ");
                                String _mail = scan.nextLine();
                                System.out.println("Enter Visitor Password: ");
                                String _pass = scan.nextLine();
                                Visitor visitor = new Visitor(_name, _age, _phnum, _bal, _mail, _pass);
                                adminUser.addVisitor(visitor);
                            }
                            case 2 -> {
                                System.out.println("Enter Visitor email:");
                                String mail = scan.nextLine();
                                System.out.println("Enter Vistor password: ");
                                String pass = scan.nextLine();
                                Visitor _visitor = adminUser.findVisitor(mail);
                                if (_visitor != null) {
                                    if (_visitor.login(mail, pass)) {
                                        System.out.println("Logged in as visitor");
                                        System.out.println();
                                        visitorMenu(_visitor);
                                    } else {
                                        System.out.println("Incorrect email or password");
                                    }
                                } else {
                                    System.out.println("Visitor not found");
                                }
                            }
                        }
                    } while (_choice != 3);
                }

                case 3 -> adminUser.viewDeal();

                case 4-> System.out.println("Thanks for visiting Zootopia!");

            }
        } while (choice != 4);
    }

    public static void adminMenu(){

        Scanner scan = new Scanner(System.in);

        int choice;
        do {
            System.out.println("Admin Menu:");
            System.out.println("1. Manage Attractions");
            System.out.println("2. Manage Animals");
            System.out.println("3. Schedule Events ");
            System.out.println("4. Set Discounts");
            System.out.println("5. Set Special Deals");
            System.out.println("6. View Visitor Stats");
            System.out.println("7. View feedback");
            System.out.println("8. Exit");

            choice = scan.nextInt();
            scan.nextLine();
            switch (choice) {
                case 1 -> {
                    int ch;
                    do {
                        System.out.println("Manage Attractions: ");
                        System.out.println("1. Add Attractions");
                        System.out.println("2. View Attractions");
                        System.out.println("3. Modify Attractions");
                        System.out.println("4. Remove Attractions");
                        System.out.println("5. Exit");
                        System.out.println();
                        System.out.println("Enter your choice: ");

                        ch = scan.nextInt();
                        scan.nextLine();
                        switch (ch) {
                            case 1 -> {
                                System.out.println("Enter Attraction Name: ");
                                String add_att = scan.nextLine();
                                System.out.println("Enter Attraction Description:");
                                String add_des = scan.nextLine();
                                System.out.println("Enter Attraction price:");
                                int add_price = scan.nextInt();
                                scan.nextLine();
                                _zoo.addAttraction(new Attraction(add_att, add_des, add_price));
                            }
                            case 2 -> _zoo.viewattractions();
                            case 3 -> {
                                System.out.println("Enter Attraction Name: ");
                                String mod_att = scan.nextLine();
                                System.out.println("Enter Attraction Description:");
                                String mod_des = scan.nextLine();

                                _zoo.modifyAttraction(mod_att, mod_des);
                            }
                            case 4 -> {

                                System.out.println("Enter Attraction Name: ");
                                String rem_att = scan.nextLine();
                                _zoo.removeAttraction(rem_att);
                            }
                        }
                    } while (ch != 5);
                }

                case 2 -> {
                    int ch;
                    do {
                        System.out.println("Manage Animals: ");
                        System.out.println("1. Add Animals");
                        System.out.println("2. Update Animal details");
                        System.out.println("3. Remove Animal");
                        System.out.println("4. Exit");
                        System.out.println();
                        System.out.println("Enter your choice: ");

                        ch = scan.nextInt();
                        scan.nextLine();
                        switch (ch) {
                            case 1 -> {
                                System.out.println("Enter Animal Name: ");
                                String animal_name = scan.nextLine();
                                System.out.println("Enter Animal Type(Mammal/Reptile/Amphibian) :");
                                String animal_type = scan.nextLine();
                                System.out.println("Enter Animal Noise:");
                                String animal_noise = scan.nextLine();
                                Animal a;
                                switch (animal_type){
                                    case "Mammal" -> a = new Mammal(animal_name, animal_noise);
                                    case "Reptile" -> a = new Reptile(animal_name,  animal_noise);
                                    case "Amphibian" -> a = new Amphibian(animal_name, animal_noise);

                                    default -> {
                                        System.out.println("Invalid Animal Type");
                                        continue;
                                    }

                                }
                                _zoo.addAnimal(a);
                            }
                            case 2 -> {
                                System.out.println("Enter Animal Name: ");
                                String animal_name = scan.nextLine();
                                System.out.println("Enter Animal Noise:");
                                String animal_noise = scan.nextLine();

                                _zoo.updateAnimal(animal_name, animal_noise);

                            }
                            case 3 -> {
                                System.out.println("Enter Animal Name: ");
                                String animal_name = scan.nextLine();

                                _zoo.removeAnimal(animal_name);
                            }
                        }
                    } while (ch != 4);
                }

                case 3 -> {
                        System.out.println("Schedule Events: ");
                        System.out.println("Find Attraction");
                        String att_name = scan.nextLine();

                        Attraction att = _zoo.findAttraction(att_name);

                        if (att == null) {
                            System.out.println("Attraction not found");
                            continue;
                        }
                        System.out.println("Do you want to open? (y/n)");
                        String open = scan.nextLine();

                        switch(open) {
                            case("y")-> {
                                System.out.println("Enter your price: ");
                                int price = scan.nextInt();
                                scan.nextLine();
                                att.setStatusOpenOrClosed(true);
                                att.setTicketPrice(price);
                            }
                            case("n")-> System.out.println("Attraction not opened");
                            default -> System.out.println("Invalid input");
                        }

                }

                case 4 -> {
                    int ch;
                    do{
                        System.out.println("Set Discounts: ");
                        System.out.println("1. Add Discount: ");
                        System.out.println("2. Remove Discount: ");
                        System.out.println("3. Exit ");

                        ch = scan.nextInt();
                        scan.nextLine();

                        switch (ch) {
                            case 1 -> {
                                System.out.println("Enter Discount Category: ");
                                String cat = scan.nextLine();

                                System.out.println("Enter Discount Percentage: ");
                                int per = scan.nextInt();
                                scan.nextLine();

                                Category category;

                                switch (cat) {
                                    case "Minor" -> category = Category.MINOR;
                                    case "Senior" -> category = Category.SENIOR;
                                    default -> {
                                        System.out.println("Invalid Category");
                                        continue;
                                    }
                                }

                                adminUser.addDiscount(category, per);

                            }

                            case 2 -> {


                                System.out.println("Enter Discount Category(Minor/Senior): ");
                                String cat = scan.nextLine();


                                System.out.println("Enter Discount Percentage: ");
                                int per = scan.nextInt();
                                scan.nextLine();

                                Category category;

                                switch (cat) {
                                    case "Minor" -> category = Category.MINOR;
                                    case "Senior" -> category = Category.SENIOR;
                                    default -> {
                                        System.out.println("Invalid Category");
                                        continue;
                                    }
                                }

                                adminUser.removeDiscount(category, per);

                            }

                        }

                    }while(ch!=3);

                }

                case 5->{
                    int ch;
                    System.out.println("Set Deal: ");
                    System.out.println("1. Add Deal: ");
                    System.out.println("2. Remove Deal: ");
                    System.out.println("3. Exit ");

                    ch = scan.nextInt();
                    scan.nextLine();

                    switch (ch) {
                        case 1->{
                            System.out.println("Enter the minimum number of attractions for the special deal: ");
                            int _notickets = scan.nextInt();
                            System.out.println("Enter the discount percentage for the special deal: ");
                            int _percentage = scan.nextInt();
                            adminUser.addDeal(_notickets, _percentage);

                        }

                        case 2->{
                            System.out.println("Enter the minimum number of attractions to remove the special deal: ");
                            int _notickets = scan.nextInt();
                            System.out.println("Enter the discount percentage to remove the special deal: ");
                            int _percentage = scan.nextInt();
                            adminUser.removeSpecialDeal(_notickets, _percentage);

                        }



                    }

                }
                case 6-> adminUser.visitorStats();
                case 7 ->_zoo.viewFeedback();
            }
        }while(choice!=8);
    }

    public static void visitorMenu(Visitor visitor){

        Scanner scan = new Scanner(System.in);

        int choice;
        do{
            System.out.println("1. Explore the Zoo");
            System.out.println("2. Buy Membership");
            System.out.println("3. Buy Tickets ");
            System.out.println("4. View Discounts");
            System.out.println("5. View Special Deals");
            System.out.println("6. Visit Animals");
            System.out.println("7. Visit Attractions");
            System.out.println("8. Leave Feedback");
            System.out.println("9. Log Out");

            System.out.println();

            System.out.println("Enter your choice: ");
            choice = scan.nextInt();

            switch(choice){
                case 1->{
                    int _choice;
                    do{
                        System.out.println("1. View Attraction");
                        System.out.println("2. View Animal");
                        System.out.println("3. Exit");

                        System.out.println();
                        System.out.println("Enter your choice: ");
                        _choice = scan.nextInt();

                        switch(_choice){
                            case 1->{
                                System.out.println("Attractions: ");
                                _zoo.viewattractions();
                                System.out.println();
                            }
                            case 2-> {
                                System.out.println("Animals: ");
                                _zoo.viewanimal();
                                System.out.println();
                            }
                        }
                    }while(_choice!=3);
                }

                case 2->visitor.buyMembership(adminUser.getDiscounts());

                case 3->visitor.buyTicket(_zoo.get_attractions(), adminUser.getDiscounts(), adminUser.getSpecialDeals());

                case 4-> adminUser.viewDiscount();

                case 5-> adminUser.viewDeal();

                case 6->{
                    int _choice;

                    System.out.println("Select animal to visit: ");
                    _zoo.viewanimal();
                    System.out.println("Enter your choice: ");
                    _choice= scan.nextInt();
                    if (_choice > 0 && _choice <= _zoo.get_animals().size()) {
                        Animal ani = _zoo.get_animals().get(_choice - 1);
                        visitor.visitAnimal(ani);
                    } else {
                        System.out.println("Invalid choice.");
                    }
                }

                case 7->{
                    System.out.println("Visit Attraction ");
                    System.out.println("Select attraction to visit");
                    _zoo.viewattractions();
                    System.out.println(_zoo.get_attractions().size() + 1 + ". Exit");
                    System.out.println();
                    System.out.println("Enter your choice: ");
                    int _choice = scan.nextInt();
                    scan.nextLine();

                    if (_choice >= 1 && _choice<= _zoo.get_attractions().size()) {
                        Attraction attraction = _zoo.get_attractions().get(_choice - 1);
                        visitor.visitAttraction(attraction);
                    }
                    else if (_choice == _zoo.get_attractions().size() + 1) System.out.println("Exiting attraction visit.");
                    else System.out.println("Invalid choice.");
                }

                case 8-> {
                    scan.nextLine();
                    System.out.println("Enter your feedback (max 200 characters): ");
                    String feedback = scan.nextLine();
                    _zoo.leaveFeedback(feedback);
                }

                case 9-> System.out.println("Logged Out.");

            }

        }while(choice!=9);

    }
}