package coe528.project;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.InputMismatchException;
import java.util.regex.Matcher;

public class Customer implements Serializable {

    private String name;

    private String email;
    
    private String password;
    
    private String creditCardInfo;

    private ShippingInfo shippingInfo;

    private Order order;
    
    private ShoppingCart shoppingCart;

    public Customer(String name, String password) {
        this.name = name;
        this.password = password;
        this.email = email;
        shippingInfo = new ShippingInfo(this.name);
        creditCardInfo = "0000000000000000";
        order = null;
        shoppingCart = new ShoppingCart();
        this.shippingInfo  = new ShippingInfo(this.name);
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
    
    public void clearCart(){
        shoppingCart.removeAllItemsInShoppingCart();
    }
    
    // User seen products
    // User choosing products by this stage
    public void addToCart(){
        int iD;
        int amount;
        int i;
        String iName;
        String iCond = null;
        Item[] Items;
        Scanner s = new Scanner(System.in);
        
        System.out.println("Please enter the name of the item you want to add the shopping cart: ");
        iName = s.next();
        System.out.println("Please enter the condition of the item you want to add the shopping cart: ");
        iCond = s.next();
        System.out.println("How many would you like have: ");
        while(!s.hasNextInt()){
            s.next();
        }
        amount = s.nextInt();
        
        //Check if item exists based on string
        Items = Catalog.getInstance().getItemsFromBrowse(iName, iCond, amount);
        if(Items != null){
            //check if the amount user requested is too high
            i = Catalog.getInstance().getNumberOfItems(iName, iCond);
            int j = 0;
            if(amount <= i){
                //adds to cart x number of times user specified
                for(j = 0; j < amount; j++){
                    shoppingCart.addtoShoppingCart(Items[j]);
                }
                System.out.println(j + " " + iCond + " " + iName + " added to shopping cart.");
                //System.out.println(shoppingCart.toString());
            }
            else{
                System.out.println("Only " + i + " of " + iCond + " " + iName + " are available in the store.");
            }
        }
        else{
            System.out.println("No such item was found");
        }
        
        /**
        item = Catalog.getInstance().getItem(iName, iCond);
        if(item != null){
            shoppingCart.addtoShoppingCart(item);
            shoppingCart.updateQuantity(amount, item);
            System.out.println("Added " + amount + " " + iName + " to shopping cart");
        }
        else{
            System.out.println("No such item was found.");
        }
        **/
    }
    
        public void removeFromCart(){
        int iD;
        int amount;
        int i;
        String iName;
        String iCond = null;
        Item[] Items;
        Scanner s = new Scanner(System.in);
        
        System.out.println("Please enter the name of the item you want to remove from the shopping cart: ");
        iName = s.next();
        System.out.println("Please enter the condition of the item you want to remove from the shopping cart: ");
        iCond = s.next();
        System.out.println("How many would you like remove: ");
        while(!s.hasNextInt()){
            s.next();
        }
        amount = s.nextInt();
        
        //check if item exist based on string
        Items = shoppingCart.getItemsFromBrowse(iName, iCond, amount);
        if(Items != null){
            //check if the amount user requested is too high
            i = shoppingCart.getNumberOfItems(iName, iCond);
            int j = 0;
            if(amount <= i){
                //adds to cart x number of times user specified
                for(j = 0; j < amount; j++){
                    shoppingCart.removeFromShoppingCart(Items[j]);
                }
                System.out.println(j + " " + iCond + " " + iName + " removed from shopping cart.");
            }
            else{
                System.out.println("Only up to " + i + " of " + iCond + " " + iName + " can be removed.");
            }
        }
        else{
            System.out.println("No such item was found.");
        }
        
        /**
        item = Catalog.getInstance().getItem(iName, iCond);
        if(item != null){
            shoppingCart.addtoShoppingCart(item);
            shoppingCart.updateQuantity(amount, shoppingCart.getItem(iName, iCond));
            System.out.println("Removed " + amount + " " + iName + " to shopping cart");
        }
        else{
            System.out.println("No such item was found.");
        }
        **/
    }
    
    public void proceedToCheckout () {
        boolean cont = false;
        String sc = null;
        Scanner s = new Scanner(System.in);
        
        //Check if Shopping Cart has an item
        
        if(shoppingCart.TotalShoppingNumber() == 0){
            System.out.println("You do not have any items in your shopping cart to checkout.");
            return;
            //throw new IllegalArgumentException();
        }

        System.out.println("----------Shopping Cart Summary----------:"+shoppingCart.toString()+"\n-----------------------------------------");
        System.out.println("Would you like to proceed to checkout? Press Y/N: ");
        while(!s.hasNext("[NnYy]")){
            s.next();
        }
        sc = s.next();
        
        if(sc.equals("Y") || sc.equals("y")){
            if (!shippingInfo.repOK()) {
                System.out.println("Shipping information was not completed, you need to complete that before proceeding");
                updateProfile();
            }
            order = shoppingCart.createOrder(shoppingCart.getItems(), shoppingCart.getSubtotal(),shippingInfo);
            System.out.println("Please verify that the information is correct.\n To confirm, press y, or otherwise press any other key\n");
            System.out.println(order.toString());
            sc = s.next();
            if (sc.equals("y") || sc.equals("Y")) {
               shoppingCart.deliverItems();
               System.out.println("Items have been scheduled for delivery.");
               System.out.println("Estimated time of arrival:" + order.getExpectedArrival());
            }
            else {
                System.out.println("Order did not go through.");
            }
            
        }
        
        
    }
 
    public void browseCatalog(){
        Scanner s = new Scanner(System.in);
        String cmd = null;
        ArrayList<Item> browsed;
        String regx = "^([A-Za-z]+) ?([A-za-z]+)?";
        Pattern ptrn = Pattern.compile(regx);
        Matcher matcher;
        
        boolean cont = true;
        while(cont){
            System.out.println("-----Browsing Catalog-----\n1: Browse Item\n2: Add to Shopping Cart\n3: Remove from Shopping Cart\n4: Return to Main Menu\n------------------------------");
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
                    System.out.print("\nPlease input item name: ");
                    /**
                    while(!s.hasNext(pattern)){
                        System.out.print("\nInput name is invalid. Please try again: ");
                        s.next();
                    }
                    cmd = s.next(pattern);
                    **/
                    cmd = s.nextLine();
                    matcher = ptrn.matcher(cmd);
                    while(!matcher.matches()){
                        cmd = s.nextLine();
                        matcher = ptrn.matcher(cmd);
                        if(!matcher.matches()){
                            System.out.print("Invalid entry. Please try again: ");
                        }
                        else{
                            break;
                        }
                    }
                    browsed = Catalog.getInstance().getItemsFromBrowse(cmd);
                    
                    //prints the search results
                    System.out.println("Results for "+cmd+":");
                    for(Item x : browsed){
                        System.out.print(x.toString()+"\n");
                    }
                    break;
                case 2:
                    addToCart();
                    break;
                case 3:
                    if(shoppingCart.TotalShoppingNumber() > 0){
                        removeFromCart();
                    }
                    else{
                        System.out.println("You don't have any items to remove from your shopping cart.");
                    }
                    break;
                case 4:
                    System.out.println("Returning to Main Menu....");
                    cont = false;
                    break;
                default:
                    break;
            }
        }
    }
    
    public void viewOrder(){
        try {
        System.out.println(order.toString());
        }
        catch (NullPointerException e) {
            System.err.println("No order exists yet.");
        }
    }
    
    public void viewCart(){
        try {
        System.out.println(shoppingCart.toString());
        }
        catch (NullPointerException e) {
            System.err.println("Shopping cart is empty");
        }
    }
    
    public void updateProfile(){
        shippingInfo.updateShippingInfo();
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