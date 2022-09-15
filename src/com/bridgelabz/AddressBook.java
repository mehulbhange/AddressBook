package com.bridgelabz;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

class AddressBook{

    private ArrayList<Contact> contacts = new ArrayList<>();
    private HashMap<String, List<Contact>> cityContactList = new HashMap<>();
    private HashMap<String, List<Contact>> stateContactList = new HashMap<>();
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

        if (isDuplicate(firstName, lastName))
            System.out.println(firstName+" "+ lastName+" already exists in contacts");
        else {
            Contact contact = new Contact(firstName, lastName, street, city, state, zip, phoneNo, email);
            contacts.add(contact);
            if (cityContactList.containsKey(city)){
                List<Contact> tempList = cityContactList.get(city);
                tempList.add(contact);
            }else {
                List<Contact> tempList = new ArrayList<>();
                tempList.add(contact);
                cityContactList.put(city,tempList);
            }
            if (stateContactList.containsKey(state)){
                List<Contact> tempList = stateContactList.get(state);
                tempList.add(contact);
            }else {
                List<Contact> tempList = new ArrayList<>();
                tempList.add(contact);
                stateContactList.put(city,tempList);
            }

        }
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

    public void deleteContact(){
        System.out.println("Enter person name : ");
        String name = sc.next();
        for(Contact contact : contacts){
            if(contact.getFirstName().equals(name) || contact.getLastName().equals(name)){
                contacts.remove(contact);
                System.out.println(contact.getFirstName() +" removed!");
                return;
            }
        }
        System.out.println(name + " not found!");
    }
    public List<Contact> getContactList(){
        return contacts;
    }

    /*
    * This method is used to check the duplicate entry
    * if first and last name already exists in addressbook then it will not return true i.e. duplicate entry
    * if duplicate return true else return false
    * */
    public boolean isDuplicate(String firstName, String lastName){
        boolean result = contacts.stream().filter(contact -> contact.getFirstName().equals(firstName) && contact.getLastName().equals(lastName)).count() > 0;
        return result;
    }
    public void searchByCityOrState(String location){
        contacts.stream().forEach(contact -> {
            if (contact.getCity().equals(location) || contact.getState().equals(location)){
                System.out.println(contact);
            }
        });
    }

    public void viewPersonsByCity(String city){
        if (cityContactList.containsKey(city)){
            List<Contact> tempList = cityContactList.get(city);
            tempList.stream().forEach(contact -> System.out.println(contact));
        }
    }
    public void viewPersonsByState(String state){
        if (stateContactList.containsKey(state)){
            List<Contact> tempList = stateContactList.get(state);
            tempList.stream().forEach(contact -> System.out.println(contact));
        }
    }
}

