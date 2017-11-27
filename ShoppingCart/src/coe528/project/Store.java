/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import java.util.Scanner;

/**
 * Overview: This is the main class of the program. It allows the user of this program
 * to act as a guest to use the store once the program starts. It's state is a summary of the catalog and the current user.
 * 
 * Abstract Function:
 * AF(c) s.t. customer in a store
 * 
 * The rep invariant is:
 * customer != null
 *
 */
public class Store {
    
    static Customer customer = null;
    /**
     * MODIFIES: customer
     * EFFECTS: initializes customer to non-null value, or exit program
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
                    System.out.print("Invalid entry. Please try again: ");
                    s.next();
                }
                try{
                    i = s.nextInt();
                } catch (Exception e){
                    System.out.print("Invalid entry. Please try again: ");
                } 
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
    
    /**
     * MODIFIES: customer, catalog
     * EFFECTS: Browse Catalog, See the customer's order, see the customer's shopping cart, modify the customer's shippingInfo, modify the customer's order, logout from the system.
     */
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
                    System.out.print("Invalid entry. Please try again: ");
                    s.next();
                }
                try{
                    i = s.nextInt();
                } catch(Exception e){
                }
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
    
    /**
     * MODIFIES: none 
     * EFFECTS: returns true if the rep invariant holds true for this object; otherwise false
     * @return 
     */
    public boolean repOK(){
        return customer != null;
    }
    
    @Override
    public String toString(){
        String object = null;
        object.concat("------------Welcome to ChimpGorden's Shopping Terminal-------------\nYour current info is:\n");
        
        return "";
    }
}
