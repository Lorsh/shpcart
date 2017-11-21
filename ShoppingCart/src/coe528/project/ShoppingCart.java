package coe528.project;


import java.util.ArrayList;

public class ShoppingCart {

    private int shoppingID;

    private ArrayList<Item> items;

    private double subtotal;

    private Catalog catalog = Catalog.getInstance();
    
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
        catalog.removeItemFromCatalog(item.getProductID());
    }
    
    public ArrayList<Item> getItems(){
        return items;
    }
    public double getsubtotal(){
    double x = 0;
    //summation of all the item
    for(int i=0;i<items.size() ;i++){
        x = items.get(i).getPrice();
        subtotal = subtotal + x;
           
    }
        return (subtotal);
    }

    public void checkOut() {
       Order y = new Order();
        
    }
    public void removeFromShoppingCart(Item item) {
        catalog.addItemToCatalog(item);
        if (catalog.checkItemExist(item.getProductID())) {
            items.remove(item);
        }
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
    
    
    public int TotalShoppingNumber(){
        return (items.size());
    }

    public String viewCartDetails() { // changed the return type to string 
        // change in the string
        //int shoppingTotal = items.size();
       String cartDetail;
       cartDetail = "Shopping ID is"  +getshoppingID()+ "Number of Items" +TotalShoppingNumber()+ "Subtotal" +getsubtotal();
       System.out.println(cartDetail);
        return cartDetail;
    }
// adding TAX (HST) to the SubTotal
    public double calculateSub() {
        double m = ((1.13*(subtotal)));
        return m;
    }
    public String toString() {
        return "Numbers of Items" +TotalShoppingNumber()+ "Total " +getsubtotal() +"After Tax " +calculateSub();
    }
}