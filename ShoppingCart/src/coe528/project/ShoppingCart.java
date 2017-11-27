package coe528.project;


import java.io.Serializable;
import java.util.ArrayList;

/**
 * Overview: ShoppingCart is a mutable unbounded collection of distinct items
 * that is initially empty. It temporarily stores items that the customer wants
 * to purchase and their subtotal.
 * 
 * Th abstraction function is:
 * AF(c): An ArrayList of unique items
 * 
 * The rep invariant is:
 * x = new Item();
 * y = new Item();
 * c.items.productID != c.items.productID for every integer x and y where x != y
 */

public class ShoppingCart implements Serializable{

    static private int shoppingID = 0;

    private ArrayList<Item> items;

    private double subtotal;

    private Catalog catalog = Catalog.getInstance();
    
    /**
     * MODIFIES: items, shoppingID
     * EFFECTS: initializes the instance ArrayList items, and increments the instance integer shoppingID by 1.
     */
    public ShoppingCart(){
        this.items = new ArrayList<Item>(); 
        shoppingID++;
    }
    
    /**
     * MODIFIES: none
     * EFFECTS: return integer instance shoppingID
     * @return 
     */
    public int getshoppingID(){
        return shoppingID; // getting the ID of the item
    }
    
    /**
     * MODIFIES: items, catalog, subtotal
     * EFFECTS: adds an item to the ArrayList instance item. removes the same item from catalog.items ArrayList. Updates the subtotal accordingly.
     * @param item 
     */
    public void addtoShoppingCart(Item item){
        items.add(item);
        catalog.removeItemFromCatalog(item.getProductID());
        subtotal = updateSubTotal();
    }
    
    /**
     * MODIFIES: items
     * EFFECTS: removes every item in the ArrayList instance items
     */
    public void removeAllItemsInShoppingCart(){
        ArrayList<Item> I = new ArrayList<Item>();
        for(Item x : items){
            I.add(x);
        }
        for(Item x : I){
            removeFromShoppingCart(x);
        }
    }
    
    /**
     * MODIFIES: items
     * EFFECTS: clears the ArrayList items
     */
    public void deliverItems() {
        items.clear();
    }
    
    /**
     * MODIFIES: none
     * EFFECTS: returns the ArrayList items.
     * @return 
     */
    public ArrayList<Item> getItems(){
        return items;
    }
    
    /**
     * MODIFIES: none 
     * EFFECTS: returns a double variable equal to the sum of the price of the items in items.
     * @return 
     */
    public double updateSubTotal(){
        double x = 0;
        //summation of all the item
        for(int i=0;i<items.size() ;i++){
            x = x +  items.get(i).getPrice();

        }
        return x;
    }
    
    /**
     * MODIFIES: none
     * EFFECT: returns the double subtotal
     * @return 
     */
    public double getSubtotal() {
        return subtotal;
    }
    
    /**
     * MODIFIES: none
     * EFFECTS: returns an integer equal to the number items that exist based on the name and condition specified.
     * @param itemName
     * @param condition
     * @return 
     */
    public int getNumberOfItems (String itemName, String condition) {
    int acum = 0;
        for (Item x : items) {
            if (x.getName().equals(itemName) && x.getCondition().equals(condition)) {
                acum++;
            }
        }
    
        return acum;
    
    }

    /**
     * MODIFIES: none
     * EFFECTS: returns an Order object.
     * @param items
     * @param subtotal
     * @param shipInfo
     * @return 
     */
    public Order createOrder(ArrayList<Item> items, double subtotal, ShippingInfo shipInfo) {
       Order y = new Order(items,subtotal,shipInfo);
        return y;
    }
    
    /**
     * MODIFIES: subtotal, items
     * EFFEECTS: removes the corresponding item from the items ArrayList, and updates the subtotal accordingly.
     * @param item 
     */
    public void removeFromShoppingCart(Item item) {
        if (!catalog.checkItemExist(item.getProductID())) {
            catalog.addItemToCatalog(item);
            items.remove(item);
        }
        subtotal = updateSubTotal();
    }
    
    /**
     * MODIFIES: none
     * EFFECTS: returns an Item array object that contains items based on the its name and its condition if it exists up to the amount specified.
     * @param itemName
     * @param itemCond
     * @param amount
     * @return 
     */
    public Item[] getItemsFromBrowse (String itemName, String itemCond, int amount) {
        //ArrayList<Item> browsedItems = new ArrayList<Item>();
        Item[] browsedItems = new Item[amount];
        int i = 0;
        for (Item x : items) {
            if (x.getName().equals(itemName) && x.getCondition().equals(itemCond)) {
                browsedItems[i] = x;
                i++;
            }
            if(i == amount){
                break;
            }
        }
    
        return browsedItems;
    
    }
    
    
  /** 
   * MODIFIES: none
   * EFFECTS: returns Item object corresponding to the name of the item and its condition if it exists.   
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
    
    /**
     * MODIFIES: none
     * EFFECTS: returns an integer equivalent to the size the ArrayList items
     * @return 
     */
    public int TotalShoppingNumber(){
        try{
        return items.size();
        }
        catch (NullPointerException e) {
            System.out.println("No items in shopping cart");
            return 0;
        }
}
    
    /**
     * MODIFIES: none
     * EFFECTS: prints a string and returns it
     * @return 
     */
    public String viewCartDetails() { // changed the return type to string 
        // change in the string
        //int shoppingTotal = items.size();---------------------------------------------------------------------+
       String cartDetail;
       cartDetail = "Shopping ID is"  +getshoppingID()+ "Number of Items" +TotalShoppingNumber()+ "Subtotal" +updateSubTotal();
       System.out.println(cartDetail);
        return cartDetail;
    }
    
    /** 
     * MODIFIES: none
     * EFFECTS: Returns true if the rep invariant holds for this    
     *            object; otherwise returns false
     **/
    public boolean repOK() { 
        for (int i=0; i< items.size();i++) { //get i_th element in arraylist
            Item org = items.get(i);
            for (int j=i+1; j< items.size();j++) { //go through all the next elements in the arraylist to make sure that items[i] doesnt appear in any of them.
                Item compare_with = items.get(j);
                if (org.getProductID() == compare_with.getProductID()) {
                    return false;
                }
                
            }
        }
        return true;
        }
 
    public String toString() {
        String a = "----------Shopping Cart Summary----------\n";
        String s = "";
        for(Item x : items){
            s = s + x.toString() + "\n";
        }
        String c = "\nNumbers of Items: " + TotalShoppingNumber() + "\nSubtotal: $" + updateSubTotal();
        String d = "\n-----------------------------------------";
        return a + s + c + d;
    }
}