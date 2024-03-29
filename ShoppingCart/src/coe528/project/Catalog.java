package coe528.project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Overview: Catalog is a Singleton, mutable, unbunded      
 * collection of distinct Items that is initially preloaded with     
 * items that are available to purchase.
 * The abstraction function is: 
 *  AF(c) : An ArrayList of unique Items
 *
 * 
 * The rep invariant is:  
 * b) Write the rep invariant here 
 *  c.items.productID != c.items.productID for every integer x and y where x != y
 */
public class Catalog implements Serializable {
    
    static private ArrayList<Item> items = new ArrayList<Item>();
    private static Catalog instance;
    private final String fileName = "catalog.txt";
    
    /**
     * MODIFIES: items,
     * EFFECTS: Writes to file, initializes items
     * @throws FileNotFoundException 
     */
    private Catalog () throws FileNotFoundException {
    try {
            FileInputStream fhi = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fhi);
            items = (ArrayList<Item>) ois.readObject();
            ois.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        }
        catch (IOException d) {
            //This is where you put the initial items in the store:
            //<editor-fold defaultstate="collapsed" desc="Code folding Item objects added to "items" arrayList">
            items.add(new Item("Bike", "New", 200));
            items.add(new Item("Bike", "New", 200));
            items.add(new Item("Bike", "New", 200));
            items.add(new Item("Bike", "Used", 100));
            items.add(new Item("Bike", "Used", 100));

            items.add(new Item("Treadmill", "New", 400));
            items.add(new Item("Treadmill", "Used", 250));
            items.add(new Item("Treadmill", "New", 400));
            items.add(new Item("Treadmill", "Used", 250));
            items.add(new Item("Treadmill", "New", 400));

            items.add(new Item("Vacuum", "New", 700));
            items.add(new Item("Vacuum", "Used", 200));
            items.add(new Item("Vacuum", "New", 700));
            items.add(new Item("Vacuum", "Used", 200));
            items.add(new Item("Vacuum", "New", 700));

            items.add(new Item("TV", "New", 2000));
            items.add(new Item("TV", "Used", 900));
            items.add(new Item("TV", "New", 2000));
            items.add(new Item("TV", "Used", 900));
            items.add(new Item("TV", "New", 2000));

            items.add(new Item("Cat", "New", 10000));
            items.add(new Item("Cat", "Used", 9999));
            items.add(new Item("Cat", "New", 10000));
            items.add(new Item("Cat", "Used", 9999));
            items.add(new Item("Cat", "New", 10000));

            items.add(new Item("Shoe", "New", 100));
            items.add(new Item("Shoe", "Used", 50));
            items.add(new Item("Shoe", "New", 100));
            items.add(new Item("Shoe", "Used", 50));
            items.add(new Item("Shoe", "New", 100));

            items.add(new Item("Drill", "New", 120));
            items.add(new Item("Drill", "Used", 80));
            items.add(new Item("Drill", "New", 120));
            items.add(new Item("Drill", "Used", 80));
            items.add(new Item("Drill", "New", 120));

            items.add(new Item("Smart Phone", "New", 1000));
            items.add(new Item("Smart Phone", "Used", 400));
            items.add(new Item("Smart Phone", "New", 1000));
            items.add(new Item("Smart Phone", "Used", 400));
            items.add(new Item("Smart Phone", "New", 1000));

            items.add(new Item("Bed", "New", 270));
            items.add(new Item("Bed", "Used", 150));
            items.add(new Item("Bed", "New", 270));
            items.add(new Item("Bed", "Used", 150));
            items.add(new Item("Bed", "New", 270));

            items.add(new Item("Table", "New", 500));
            items.add(new Item("Table", "Used", 100));
            items.add(new Item("Table", "New", 500));
            items.add(new Item("Table", "Used", 200));
            items.add(new Item("Table", "New", 500));
            //</editor-fold>

            update();
        }
    }
       /**
        * MODIFIES: instance variable
        * EFFECTS: Creates an instance of Catalog in the Catalog class if it doesn't exist already.
        * @return 
        */
       public static Catalog getInstance()  {
        if (instance == null) {
            try {
                instance = new Catalog();
            } catch (FileNotFoundException ex) {
                System.out.println("file not found");
            }
        }
        return instance;
    }  
     
     /**
      * MODIFIES: none
      * EFFECTS: Updates the file in which it stores the state of items arrayList.
      */  
     public void update(){
        try {
            FileOutputStream fho = new FileOutputStream (fileName);
            ObjectOutputStream oos = new ObjectOutputStream (fho);
            oos.writeObject(items);
            oos.close();
        }
        catch (IOException e) {
            System.err.println(e);
        }
    }   

    /**
     * MODIFIES: items arrayList
     * EFFECTS: Removes an item from arrayList if it exists and updates the file.
     * @param productID 
     */ 
    public void removeItemFromCatalog (int productID){
        try {
            items.remove(items.indexOf(getItem(productID)));
            update();
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Array out of bounds exception");
        }      
    }
    
    /**
     * MODIFIES: none
     * EFFECTS: returns true if itemID exists in items arrayList.
     * @param itemID
     * @return 
     */
    public boolean checkItemExist(int itemID){
    for (Item item : items){
        if (item.getProductID() == itemID) {
            return true;
        }
        
    }
    return false;
    }
    
    /**
     * MODIFIES: items
     * EFFECTS: sets all Item objects to null and makes items.size() = 0
     */
    public void clear(){
    items.clear();
    update();
    
    }
    
    /**
     * MODIFIES: none
     * EFFECTS: returns Item object corresponding to the itmID if it exists.
     * @param itemID
     * @return 
     */
    public Item getItem (int itemID) {
    int index;
    if (checkItemExist(itemID)) {
        for (Item x : items) {
            if (x.getProductID() == itemID) {
                return x;
            }
        }
    
    }
    return null;
    
    }
    
    /**
     * MODIFIES: none
     * EFFECTS: returns an Item ArrayList object that contains items based on the its name
     * @param itemName
     * @return 
     */
    public ArrayList<Item> getItemsFromBrowse (String itemName) {
        ArrayList<Item> browsedItems = new ArrayList<Item>();
        for (Item x : items) {
            if (x.getName().equals(itemName)) {
                browsedItems.add(x);
            }
        }
    
    return browsedItems;
    
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
    
      /** MODIFIES: none
        EFFECTS: returns Item object corresponding to the name and condition of the item if it exists. 
    
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
    
    
        /** MODIFIES: items arrayList
        EFFECTS: adds Item to items arrayList and updates the file.
    
    **/

    
    public void addItemToCatalog(Item item) {
    if (!checkItemExist(item.getProductID())){
    items.add(item);
    update();
    }
    }
    
         /** MODIFIES: none
        EFFECTS: Returns true if the rep invariant holds for this    
                 object; otherwise returns false
    
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
      
      /**
       * MODIFIES: none
       * EFFECTS: returns a String that shows all the toString() of every item in object's ArrayList items.
       * @return 
       */
      @Override
      public String toString() {
        String output = "Items in Catalog:\n";
        for (Item x : items) {
            output.concat(x.toString() + "\n");
        }
        return output; 
      }
}