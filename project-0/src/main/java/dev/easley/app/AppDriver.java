package dev.easley.app;

import dev.easley.models.User;
import dev.easley.services.SuppliesService;
import dev.easley.services.SupplyRequestServices;
import dev.easley.services.UserServices;
import dev.easley.services.exception.InvalidCharacterException;

import java.util.Scanner;

public class AppDriver {
    public static User user;
    public static Scanner scanner = new Scanner(System.in);

    private static UserServices userServices = new UserServices();

    private static SupplyRequestServices supplyRequestServices = new SupplyRequestServices();

    private static SuppliesService suppliesService = new SuppliesService();



    public static void main(String[] args) {
    Boolean running = true;
    while (running) {
    System.out.println("Welcome Citizen.\nSelect An Option Below.");
    System.out.println("1. Login\n2. Create an Account\n3. Quit");

    int input = scanner.nextInt();

    switch (input) {

        case 1: {

            scanner.nextLine();

            System.out.println("Enter your username: ");
            String username = scanner.nextLine();

            System.out.println("Enter your password: ");
            String password = scanner.nextLine();

            AppDriver.user = userServices.getUser(username);
            boolean signInResponse = userServices.login(username, password);

            if (signInResponse) {
                System.out.println("Success. Logging in...");
                switch2();
            } else {
                System.out.println("Invalid Credentials. Try Again...");
            }
            break;

        }
        case 2: {
            scanner.nextLine();

            System.out.println("Enter a username:");
            String username = scanner.nextLine();
            System.out.println("Enter a password:");
            String password = scanner.nextLine();
            System.out.println("Are you a Townsman or Provider?");
            String user_type = scanner.nextLine();
            try {
                userServices.accountCreation(username, password, user_type);
            } catch (InvalidCharacterException ex) {
                System.out.println("Invalid Character in Username");
            }

            break;
        }

        case 3: {
            System.out.println("Goodbye...");
            running = false;
            break;
        }

        default: {
            System.out.println("Invalid Entry");
        }
    }

}

    }

    private static void switch2() {
        String usern = user.getUsername();
        String user_type = user.getUser_type();

        System.out.println("----------------------------------");
        System.out.println("Hello " + usern + "! (" + user_type + ")\n:Home Screen:\nSelect an option below.");
        System.out.println("1. Request Supplies\n2. Log Supplies\n3. View Your Supplies\n4. Fulfill Supply Request (Providers Only)\n5. Quit");
            int input = scanner.nextInt();
        switch(input) {

            case 1: {

                scanner.nextLine();
                System.out.println("Which Supplies? |Food|Materials|Medical|");
                String resource = scanner.nextLine();
                System.out.println("How much?");
                Integer resource_amount = scanner.nextInt();
                System.out.println("What Priority?(1-3)");
                Integer priority_level = scanner.nextInt();
                Integer requester_id = user.getUser_id();

                boolean sr = supplyRequestServices.requestSupplies(resource, resource_amount, priority_level, requester_id);
                if (sr) {
                    System.out.println("Created");
                }else {
                System.out.println("Resource not recognized. Please only input |Food|Materials|Medical|");

                }switch2();
                break;
            }

             case 2: {
                 scanner.nextLine();
                 System.out.println("Which resource? |Food|Medical|Materials|");
                 String resources = scanner.nextLine();
                 System.out.println("How much?");
                 Integer resource_amount = scanner.nextInt();

                 boolean ss = suppliesService.createSupplies(resources, resource_amount, user);
                 if (ss) {
                     System.out.println("Supplies Added");
                 }else {
                     System.out.println("Resource not recognized. Please only input |Food|Materials|Medical|");
                 switch2();
                 }
             break;
        }
            case 3: {
                   suppliesService.getSuppliesById(user.getUser_id());
                }
                switch2();

                break;
            case 4: {
            if (user_type.equals("Provider")) {
                System.out.println("----------------------------------");
                System.out.println(":Current list of supply requests:\nResource --- Amount --- Civilian Id");
                suppliesService.supplyRequestList();
                System.out.println("Which user (by ID)?");
                Integer citizen_id = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Which resource? |Food|Materials|Medical|");
                String resources = scanner.nextLine();

                boolean ss = supplyRequestServices.updateSupplies(citizen_id, resources);
                if (ss) {
                    System.out.println("Removal Completed.");
                }else {
                    System.out.println("Resource not recognized. Please only input |Food|Materials|Medical|");
                }
                switch2();
                break;
                }
            else {
                System.out.println("Providers only");
                switch2();
                }
            }
            case 5: {
                main(null);
                System.out.println("Goodbye");
                break;

            }
            default: {
                System.out.println("Invalid Entry");
                switch2();
            }
        }
    }
}
