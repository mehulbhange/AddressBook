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

}

