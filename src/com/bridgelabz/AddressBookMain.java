package com.bridgelabz;

import java.util.Scanner;

public class AddressBookMain {


    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");
        Scanner sc = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();

        while (true){
            System.out.println("0.Exit \n1.Add Contact \n2.Display Contact ");
            int ch = sc.nextInt();
            switch (ch){
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    addressBook.addContact();
                    break;
                case 2:
                    addressBook.displayContact();
                    break;
                default:
                    System.out.println("Invalid Input");
            }
        }




    }
}
