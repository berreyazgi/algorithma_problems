package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
         Scanner scan = new Scanner(System.in);

        LinkedList economy_passangers_list  = new LinkedList();          
        LinkedList economy_premium_passangers_list= new LinkedList();   
        LinkedList business_passangers_list = new LinkedList();         
        LinkedList cabin_crew_list = new LinkedList();       

        // Tüm listeleri tutacak linked list
        LinkedList list_of_lists = new LinkedList();

        list_of_lists.insert(economy_passangers_list);
        list_of_lists.insert(economy_premium_passangers_list);
        list_of_lists.insert(business_passangers_list);
        list_of_lists.insert(cabin_crew_list);
    

    int operation;

    do {
        System.out.println("Enter the operation: ");
        System.out.println("1: Add a person");
        System.out.println("2: Print all the lists");
        System.out.println("3: Delete all the people with the given ID");
        System.out.println("4: Combine all the lists sorted by ID, print and then exit");

        operation = scan.nextInt();
        scan.nextLine();

        // switch-case ile işlemleri 
        switch (operation) {
            case 1:
                System.out.print("Enter the name: ");
                String name = scan.nextLine();

                System.out.print("Enter the ID: ");
                long id = Long.parseLong(scan.nextLine());

                System.out.print("Enter the type (passanger or cabin-crew): ");
                String type = scan.nextLine().trim();

        if (type.equalsIgnoreCase("passanger")) {

            System.out.print("Enter the ticket type (economy, economy-premium, business): ");
            String ticket = scan.nextLine().trim();

            System.out.print("Enter the priority: ");
            int priority = Integer.parseInt(scan.nextLine());

                Passanger p = new Passanger(name, type, id, ticket, priority);

                 //Passengerları listeye kaydetmek için
                if (ticket.equalsIgnoreCase("economy")) {
                    economy_passangers_list.insert(p);
                } else if (ticket.equalsIgnoreCase("economy-premium")) {
                    economy_premium_passangers_list.insert(p);
                } else if (ticket.equalsIgnoreCase("business")) {
                    business_passangers_list.insert(p);
                } else {
                 System.out.println("Invalid ticket type!");
            }

        } else if (type.equalsIgnoreCase("cabin-crew")) {

            System.out.print("Enter the job: ");
            String job = scan.nextLine().trim();

            System.out.print("Enter the credit: ");
            double credit = Double.parseDouble(scan.nextLine());

            Cabin_Crew c = new Cabin_Crew(name, type, id, job, credit);
            cabin_crew_list.insert(c);

    } else {
        System.out.println("Invalid type!");
    }

    break;
            case 2:
                list_of_lists.displayList();
                break;
            case 3:
                 System.out.print("Enter the ID to delete: ");
                long deleteId = Long.parseLong(scan.nextLine());
                LinkedList.deleteEverywhere(list_of_lists, deleteId);
                break;
            case 4:
                LinkedList combined = LinkedList.combineById(list_of_lists);
                combined.displayList();
                System.out.println("Program ended.");
                return;
            default:
                System.out.println("Invalid choice!");
        }

    } while (operation != 4);

    scan.close();
}
}

    
