package coe528.project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class Catalog {
    
    // Overview: Catalog is a Singleton, mutable, unbunded     
    // collection of distinct Items that is initially preloaded with     
    // items that are available to purchase.
    // The abstraction function is: 
    // a) Write the abstraction function here 
    //  AF(c) : An ArrayList of unique Items
    // 
    // 
    // The rep invariant is:  
    // b) Write the rep invariant here 
    //  c.items.purchaseID != c.items.purhcaseID for every integer x and y where x != y
    //  
    //  
    // 
    
    

    static private ArrayList<Item> items = new ArrayList<Item>();
    private static Catalog instance;
    private final String fileName = "catalog.txt";
    
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
        update();
    }
     
    
    }
    /** MODIFIES: instance variable
        EFFECTS: Creates an instance of Catalog in the Catalog class if it doesn't exist already.
    
    **/
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
     
    /** MODIFIES: none
        EFFECTS: Updates the file in which it stores the state of items arrayList.
    
    **/
     public void update(){
    try {
    FileOutputStream fho = new FileOutputStream (fileName);
    ObjectOutputStream oos = new ObjectOutputStream (fho);
    oos.writeObject(items);
    oos.close();
    }
    catch (IOException e) {
    System.err.println("IO exception found");
    }
    }   
     
     /** MODIFIES: items arrayList
        EFFECTS: Removes an item from arrayList if it exists and updates the file.
    
    **/
     
    public void removeItemFromCatalog (int productID){
    try {
    items.remove(items.indexOf(getItem(productID)));
    update();
    }
    catch (ArrayIndexOutOfBoundsException e) {
     System.err.println("Array out of bounds exception");
    }
    finally {
     if (!checkItemExist(productID)) {
        System.out.println("Item " + productID + " was successfuly deleted");
    } else {
       System.err.println("Item " + productID + " was not deleted");
    }
    }
            
            
    }
    
     
    /** MODIFIES: none
        EFFECTS: returns true if itemID exists in items arrayList.
    
    **/
    
    
    public boolean checkItemExist(int itemID){
    for (Item item : items){
        if (item.getProductID() == itemID) {
            return true;
        }
        
    }
    return false;
    }
    
    /** MODIFIES: none
        EFFECTS: returns Item object corresponding to the itmID if it exists. 
    
    **/
    
    public void clear(){
    items.clear();
    update();
    
    }
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
    
        /** MODIFIES: items arrayList
        EFFECTS: adds Item to items arrayList and updates the file.
    
    **/
    
    
    public void addItemToCatalog(Item item) {
    if (!checkItemExist(item.getProductID())){
    items.add(item);
    update();
    if (checkItemExist(item.getProductID())) {
    System.out.println("Item was successfuly created");
    }
    else {
    System.err.println("item " + item.getProductID() + " was not created");
    }
    }
    else {
    System.err.println("item already exists");
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
}