/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import java.util.Scanner;

/**
 *
 * @author mshakul
 */
public class Store {

    /**
     * @param args the command line arguments //
     */
    public static void main(String[] args) {
        boolean cont = true;                //Keeps track to exit program
        Scanner s = new Scanner(System.in);
        Database database = Database.getInstance();
        System.out.println("Welcome to Ex1 Bank! \nAccessing Terminal..... \n");
        
        BankTerminalStart:
        
        while(cont){
            CheckForCustomers:
            System.out.println("\n\n------Main Menu------\n1: Login\n2: Use as Guest\n3: Exit\n----------------------");
            System.out.print("\nPlease enter a number: ");
            int i = 0;
            LoginMenuNumber:
            while(!(i >= 1 && i <= 3)){
                while(!s.hasNextInt()){
                    i = s.nextInt();
                }
                i = s.nextInt();
                if(!(i >= 1 && i <= 3)){
                    System.out.print("Invalid entry. Please try again: ");
                }
                else{
                    break LoginMenuNumber;
                }
            }
            switch (i) {
                case 1:
                    customerLogin();
                    break;
                case 2:
                    //
                    break;
                case 3:
                    System.out.println("Closing Bank Terminal........");
                    cont = false;
                    break;
                default:
                    break;
            }
        }
    }
    
    public static void customerLogin(){
        //<editor-fold defaultstate="collapsed" desc="LOGIN SEQUENCE">
        Scanner s = new Scanner(System.in);
        String us;
        String ps;
        
        System.out.print("Enter username: ");
        while(!s.hasNext()){
            us = s.next();
        }
        us = s.next();
        System.out.print("Enter password: ");
        while(!s.hasNext()){
            ps = s.next();
        }
        ps = s.next();
        
        //username and password check
        Login login = new Login(us,ps);
        while(login.condition() == false){
            System.out.print("Enter username: ");
            while(!s.hasNext()){
                us = s.next();
            }
            us = s.next();
            System.out.print("Enter password: ");
            while(!s.hasNext()){
                ps = s.next();
            }
            ps = s.next();
            
        }
        //</editor-fold>
        
        System.out.println("\nCustomer login successful!\nEntering Main Menu.......\n");
        
        //Main Menu for Customer
        boolean cont = true;
        while(cont){
            System.out.println("-----"+us+"'s Main Menu-----\n1: Browse Catalog\n2: View Order\n3: Update Profile\n4: Proceed to Checkout\n5: Logout\n------------------------------");
            System.out.print("Please enter a number: ");
            int i = 0;
            CustomerMenuNumber:
            while(!(i >= 1 && i <= 4)){
                while(!s.hasNextInt()){
                    i = s.nextInt();
                }
                i = s.nextInt();
                if(!(i >= 1 && i <= 4)){
                        System.out.print("Invalid entry. Please try again: ");
                    }
                    else{
                        break CustomerMenuNumber;
                }
            }
            switch (i) {
                case 1:
                    customer.browseCatalog();
                    break;
                case 2:
                    customer.viewOrder();
                    break;
                case 3:
                    customer.updateProfile();
                    break;
                case 4:
                    customer.proceedToCheckout();
                case 5:
                    System.out.println("Logging out....");
                    cont = false;
                    break;
                default:
                    break;
            }
        }
    }
}
