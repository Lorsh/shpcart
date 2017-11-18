package coe528.project;

import java.io.IOException;
import java.util.ArrayList;

public class ShoppingCart {

    private int shoppingID;

    private ArrayList<Item> items;

    private double subtotal;

    public ShoppingCart(int shoppingID, double subtotal) {
        this.items = new ArrayList<Item>(); 
        this.shoppingID = shoppingID;
        this.subtotal = subtotal;
        
        
    }
    public int getshoppingID(){
        return shoppingID; // getting the ID of the item
    }
    public void addtoShoppingCart(Item item){
        items.add(item);
    }
    public double getsubtotal(){
    double x = 0;
//summation of all the item
    for(int i=0;i<items.size() ;i++){
        x = items.get(shoppingID).getPrice();
        subtotal = subtotal + x;
           
    }
        return (subtotal);
    }

    public void checkOut() {
       Order y = new Order();
        
    }

    public void updateQuantity(Catalog n) { //take the reference of the item from the shopping chart and put that into the chopping chart
        // find reference of item in the catalog. If they matches 
        int currentId;
        for(int i=0;i<items.size(); i++){
        currentId = items.get(i).getProductID();
        try{
        n.removeItemFromCatalog(currentId);
        }
        catch(IOException e)
                {
                    System.out.println("Invalid ID of the Item");
                }
        }
    }
    
    public int TotalShoppingNumber(){
        return (items.size());
    }

    public void viewCartDetails() {
        //int shoppingTotal = items.size();
        System.out.println("Shopping ID is " +getshoppingID() +"\nNumber of Items " +TotalShoppingNumber()+ "\nSubtotal " +getsubtotal() );
    }
// adding TAX (HST) to the SubTotal
    public double calculateSub() {
        double m = ((0.13*(subtotal))+subtotal);
        return m;
    }
    public String toString() {
        return "Numbers of Items" +TotalShoppingNumber()+ "Total " +getsubtotal() +"After Tax " +calculateSub();
    }
}