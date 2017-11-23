package coe528.project;

import java.io.Serializable;
import java.util.Scanner;

public class Customer implements Serializable {

    private String name;

    private String address;

    private String email;
    
    private String password;
    
    private String creditCardInfo;

    private ShippingInfo shippingInfo;

    private Order order;
    
    private ShoppingCart shoppingCart;

    public Customer(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }
    
     public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getCreditCardInfo() {
        return creditCardInfo;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
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
    
        public void removeFromCart(){
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
    
    public void proceedToCheckout(){
        boolean cont = false;
        String sc = null;
        Scanner s = new Scanner(System.in);
        
        //Check if Shopping Cart has an item
        if(shoppingCart.TotalShoppingNumber() == 0){
            System.out.println("You do not have any items in your shopping cart to checkout.");
            return;
        }

        System.out.println("----------Shopping Cart Summary----------:"+shoppingCart.toString()+"\n-----------------------------------------");
        System.out.println("Would you like to proceed to checkout? Press Y/N: ");
        while(!s.hasNext("[NnYy]")){
            s.next();
        }
        sc = s.next();
        
        if(sc.equals("N") || sc.equals("n")){
            return;
        }

        order = shoppingCart.createOrder(shoppingCart.getItems(), shoppingCart.getSubtotal());
    }
    
     @Override
   public boolean equals(Object obj) {
   if (obj == null) {
       return false;
   }
   if (!Customer.class.isAssignableFrom(obj.getClass())) {
   return false;
   }
   final Customer acc = (Customer) obj;
   if ((this.name == null) ? (acc.name != null) : !this.name.equals(acc.name)){
   return false;
   }
    if ((this.password == null) ? (acc.password != null) : !this.password.equals(acc.password)){
   return false;
   }
   return true;
   }
}
