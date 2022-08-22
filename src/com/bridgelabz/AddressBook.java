package com.bridgelabz;

import java.util.ArrayList;
import java.util.Scanner;

class AddressBook {

    private ArrayList<Contact> contacts = new ArrayList<>();

    private Scanner sc = new Scanner(System.in);

    public void addContact(){
        System.out.println("Enter first and last name : ");
        String firstName = sc.next();
        String lastName = sc.next();
        System.out.println("Enter street : ");
        String street = sc.next();
        System.out.println("Enter city and state : ");
        String city = sc.next();
        String state = sc.next();
        System.out.println("Enter zip : ");
        int zip = sc.nextInt();
        System.out.println("Enter contact number : ");
        long phoneNo = sc.nextLong();
        System.out.println("Enter email id : ");
        String email = sc.next();

        contacts.add(new Contact(firstName,lastName,street,city,state,zip,phoneNo,email));

    }

    public void displayContact(){
        for (Contact contact : contacts){
            System.out.println(contact);
        }
    }

    public void editContact(){
        System.out.println("Enter person name : ");
        String name = sc.next();
        for(Contact contact : contacts){
            if(contact.getFirstName().equals(name) || contact.getLastName().equals(name)){
                System.out.println("What you want to edit : \n" +
                        "1.first name \t" +
                        "2.last name \t" +
                        "3.street \t" +
                        "4.city \t" +
                        "5.state \t" +
                        "6.zip \t" +
                        "7.contact number \t" +
                        "8.email");
                int ch = sc.nextInt();
                switch (ch){
                    case 1:
                        System.out.println("Enter first name :");
                        contact.setFirstName(sc.next());
                        System.out.println("Contact updated!");
                        break;
                    case 2:
                        System.out.println("Enter last name :");
                        contact.setLastName(sc.next());
                        System.out.println("Contact updated!");
                        break;
                    case 3:
                        System.out.println("Enter street :");
                        contact.setStreet(sc.next());
                        System.out.println("Contact updated!");
                        break;
                    case 4:
                        System.out.println("Enter city :");
                        contact.setCity(sc.next());
                        System.out.println("Contact updated!");
                        break;
                    case 5:
                        System.out.println("Enter state :");
                        contact.setState(sc.next());
                        System.out.println("Contact updated!");
                        break;
                    case 6:
                        System.out.println("Enter zip code :");
                        contact.setZip(sc.nextInt());
                        System.out.println("Contact updated!");
                        break;
                    case 7:
                        System.out.println("Enter contact number :");
                        contact.setPhoneNo(sc.nextLong());
                        System.out.println("Contact updated!");
                        break;
                    case 8:
                        System.out.println("Enter email :");
                        contact.setEmail(sc.next());
                        System.out.println("Contact updated!");
                        break;
                    default:
                        System.out.println("Invalid input.");
                }
                return;
            }
        }
        System.out.println(name + " not found!");
    }

}

