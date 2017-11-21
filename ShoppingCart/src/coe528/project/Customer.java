package coe528.project;

import java.util.Scanner;

public class Customer {

    private String name;

    private String address;

    private String email;

    private String creditCardInfo;

    private ShippingInfo shippingInfo;

    private double accountBalance;

    private Order order;
    
    private ShoppingCart shoppingCart;

    public Customer() {
    }
    
    
    // User seen products
    // User choosing products by this stage
    public void addToCart(){
        int iD;
        int amount;
        int i;
        String iName;
        String iCond = null;
        Scanner s = new Scanner(System.in);
        
        System.out.println("Please enter the name of the item you want to add the shopping cart: ");
        iName = s.next();
        System.out.println("How many would you like have: ");
        while(!s.hasNextInt()){
            s.next();
        }
        amount = s.nextInt();
        
        if(Catalog.getInstance().getItem(iName, iCond) != null){
            shoppingCart.updateQuantity(amount, shoppingCart.getItem(iName, iCond));
        }
        
        System.out.println("Added " + amount + " " + iName + " to shopping cart");
    }
    
        public void removeToCart(){
        int iD;
        int amount;
        int i;
        String iName;
        String iCond = null;
        Scanner s = new Scanner(System.in);
        
        System.out.println("Please enter the name of the item you want to remove the shopping cart: ");
        iName = s.next();
        System.out.println("How many would you like have: ");
        while(!s.hasNextInt()){
            s.next();
        }
        amount = s.nextInt();
        
        if(Catalog.getInstance().getItem(iName, iCond) != null){
            shoppingCart.updateQuantity(amount, shoppingCart.getItem(iName, iCond));
        }
        
        System.out.println("Removed " + amount + " " + iName + " to shopping cart");
    }
    
    public void login() {
        
    }
}
