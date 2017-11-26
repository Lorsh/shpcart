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
    static Customer customer = null;
    /**
     * @param args the command line arguments //
     */
    public static void main(String[] args) {
        boolean cont = true;                //Keeps track to exit program
        Scanner s = new Scanner(System.in);
        
        Database database = Database.getInstance();
        System.out.println("Welcome to ChimpGorden! \nAccessing Terminal..... \n");
        
        BankTerminalStart:
        
        while(cont){
            CheckForCustomers:
            System.out.println("\n\n------Main Menu------\n1: Use as Guest\n2: Exit\n----------------------");
            System.out.print("\nPlease enter a number: ");
            int i = 0;
            LoginMenuNumber:
            while(!(i >= 1 && i <= 2)){
                while(!s.hasNextInt()){
                    i = s.nextInt();
                }
                i = s.nextInt();
                if(!(i >= 1 && i <= 2)){
                    System.out.print("Invalid entry. Please try again: ");
                }
                else{
                    break LoginMenuNumber;
                }
            }
            switch (i) {
                case 1:
                    Login login = new Login("guest","guest");
                    customer = login.getProf();
                    mainMenu();
                    break;
                case 2:
                    if(customer != null){
                        customer.clearCart();
                    }
                    System.out.println("Goodbye");
                    cont = false;
                    break;
                default:
                    break;
            }
        }
    }
    
    public static void mainMenu(){
        Scanner s = new Scanner(System.in);
        boolean cont = true;
        while(cont){
            System.out.println("-----"+customer.getName()+"'s Main Menu-----\n1: Browse Catalog\n2: View Order\n3: View Shopping Cart\n4: Update Profile\n5: Proceed to Checkout\n6: Logout\n------------------------------");
            System.out.print("Please enter a number: ");
            int i = 0;
            CustomerMenuNumber:
            while(!(i >= 1 && i <= 6)){
                while(!s.hasNextInt()){
                    i = s.nextInt();
                }
                i = s.nextInt();
                if(!(i >= 1 && i <= 6)){
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
                    customer.viewCart();
                    
                    break;
                case 4:
                    customer.updateProfile();
                    
                    break;
                    
                case 5:
                    customer.proceedToCheckout();
                    
                    continue;
                case 6:
                    System.out.println("Logging out....");
                    cont = false;
                     break;
                default:
                    break;
            }
        }
    }
}
