package coe528.project;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.InputMismatchException;

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
    
    
    // User seen products
    // User choosing products by this stage
    public void addToCart(){
        int iD;
        int amount;
        int i;
        String iName;
        String iCond = null;
        Item item = null;
        Scanner s = new Scanner(System.in);
        
        System.out.println("Please enter the name of the item you want to add the shopping cart: ");
        iName = s.next();
        System.out.println("Please enter the condition of the item you want to add the shopping cart: ");
        iCond = s.next();
        System.out.println("How many would you like have: ");
        while(!s.hasNextInt()){
            amount = s.nextInt();
        }
        amount = s.nextInt();
        
        //Check if item exists based on string
        item = Catalog.getInstance().getItem(iName, iCond);
        if(item != null){
            //check if the amount user requested is too high
            i = Catalog.getInstance().getNumberOfItems(iName, iCond);
            if(amount == i){
                //adds to cart x number of times user specified
                for(i = 0; i >= amount; i++){
                    shoppingCart.addtoShoppingCart(item);
                }
                System.out.println(i + " " + iCond + " " + iName + " added to shopping cart.");
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
        Item item = null;
        Scanner s = new Scanner(System.in);
        
        System.out.println("Please enter the name of the item you want to remove the shopping cart: ");
        iName = s.next();
        System.out.println("Please enter the condition of the item you want to add the shopping cart: ");
        iCond = s.next();
        System.out.println("How many would you like have: ");
        while(!s.hasNextInt()){
            amount = s.nextInt();
        }
        amount = s.nextInt();
        
        //check if item exist based on string
        item = shoppingCart.getItem(iName, iCond);
        if(item != null){
            //check if the amount user requested is too high
            i = shoppingCart.getNumberOfItems(iName, iCond);
            if((i - amount) >= 0){
                //adds to cart x number of times user specified
                for(i = 0; i >= amount; i++){
                    shoppingCart.removeFromShoppingCart(item);
                }
                System.out.println(i + " " + iCond + " " + iName + " removed from shopping cart.");
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
    
    public void browseCatalog(){
        Scanner s = new Scanner(System.in);
        String cmd = null;
        ArrayList<Item> browsed;
        String regx = "^\\p{L}+[\\p{L}\\p{Z}\\p{P}]{0,}";
        Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
        
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
                    while(!s.hasNext(pattern)){
                        cmd = s.next(pattern);
                    }
                    cmd = s.next(pattern);
                        
                        try {
                           cmd = s.next(pattern);
                        }
                        catch (InputMismatchException e) {
                            //s.reset();
                            System.out.println("Input name is invalid");    
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
                    if(!(shoppingCart.TotalShoppingNumber() > 0)){
                        removeFromCart();
                    }
                    else{
                        System.out.println("You don't have any items to remove from shopping cart");
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
        
    }
    
    public void updateProfile(){
        shippingInfo.updateShippingInfo();
    }
    
    public void login() {
        
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
