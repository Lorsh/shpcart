package coe528.project;


import java.io.Serializable;
import java.util.ArrayList;

public class ShoppingCart implements Serializable{

    static private int shoppingID = 0;

    private ArrayList<Item> items;

    private double subtotal;

    private Catalog catalog = Catalog.getInstance();
    
    public ShoppingCart(){
        this.items = new ArrayList<Item>(); 
        shoppingID++;
    }
    public int getshoppingID(){
        return shoppingID; // getting the ID of the item
    }
    public void addtoShoppingCart(Item item){
        
        items.add(item);
        catalog.removeItemFromCatalog(item.getProductID());
        subtotal = updateSubTotal();
    }
    public void removeAllItemsInShoppingCart(){
        items.clear();
    }
    
    public ArrayList<Item> getItems(){
        return items;
    }
    public double updateSubTotal(){
    double x = 0;
    //summation of all the item
    for(int i=0;i<items.size() ;i++){
        x = x +  items.get(i).getPrice();
           
    }
        return x;
    }

    public double getSubtotal() {
        return subtotal;
    }
    
    

    public Order createOrder(ArrayList<Item> items, double subtotal) {
       Order y = new Order(items,subtotal);
        return y;
    }
    public void removeFromShoppingCart(Item item) {
        if (catalog.checkItemExist(item.getProductID())) {
            items.remove(item);
        }
        subtotal = updateSubTotal();
    }
    public void updateQuantity(int x, Item item) { //take the reference of the item from the shopping chart and put that into the chopping chart
        int accum = 0;
        int changes = 0;
        for (Item c : items) {
            if (c.equals(item)) {
                accum++;
            }
        }
        if (x - accum > 0) { //add items
            while (x > accum) {
                addtoShoppingCart(catalog.getItem(item.getName(), item.getCondition()));
                accum++;
                changes++;
            }
            if (changes == 1) {
                System.out.println(changes + " more item was added");
            } else {
                System.out.println(changes + " more items were added");
            }
        } else if (x - accum < 0) { // remove items
            while (x < accum) {
                removeFromShoppingCart(catalog.getItem(item.getName(), item.getCondition()));
                accum--;
                changes++;
            }
            if (changes == 1) {
                System.out.println(changes + " more item was removed");
            } else {
                System.out.println(changes + " more items were removed");
            }
        } else {
            System.out.println("No change was made");
        }

    }
    
  /** MODIFIES: none
  EFFECTS: returns Item object corresponding to the name of the item and its condition if it exists.   
 **/
   public Item getItem (String itemName, String condition) {
    int index;
        for (Item x : items) {
            if (x.getName().equals(itemName) && x.getCondition().equals(condition)) {
                return x;
            }
        }
    
    return null;
    
    }
   
    public int TotalShoppingNumber(){
        try{
        return items.size();
        }
        catch (NullPointerException e) {
            System.out.println("No items in shopping cart");
            return 0;
        }
    }

    public String viewCartDetails() { // changed the return type to string 
        // change in the string
        //int shoppingTotal = items.size();---------------------------------------------------------------------+
       String cartDetail;
       cartDetail = "Shopping ID is"  +getshoppingID()+ "Number of Items" +TotalShoppingNumber()+ "Subtotal" +updateSubTotal();
       System.out.println(cartDetail);
        return cartDetail;
    }

 
    public String toString() {
        return "Numbers of Items " +TotalShoppingNumber()+ " Subtotal " +updateSubTotal();
    }
}