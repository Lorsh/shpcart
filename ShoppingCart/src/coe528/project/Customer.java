package coe528.project;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

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
    
    public void browseCatalog(){
        
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
                    Scanner s = new Scanner(System.in);
                    String cmd = null;
                    ArrayList<Item> browsed;
                    String regx = "^\\p{L}+[\\p{L}\\p{Z}\\p{P}]{0,}";
                    Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);

                    System.out.print("\nPlease input item name: ");
                    while(!s.hasNext(pattern)){
                        s.next(pattern);
                    }
                    cmd = s.next(pattern);
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
                    if(shoppingCart.TotalShoppingNumber() != 0){
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
