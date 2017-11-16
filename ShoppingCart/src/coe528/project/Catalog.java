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
    //  top = items[n-1], where n is the size of the array.
    // 
    // 
    // The rep invariant is:  
    // b) Write the rep invariant here 
    //  c.items[x] != c.items[y] for every integer x and y where x != y
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
        
        
        
        try {
            update();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
     
    
    }
     
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
     

     public void update() throws IOException{
    
    FileOutputStream fho = new FileOutputStream (fileName);
    ObjectOutputStream oos = new ObjectOutputStream (fho);
    oos.writeObject(items);
    oos.close();
    }   
     
    public void removeItemFromCatalog (int productID) throws IOException,ArrayIndexOutOfBoundsException {
    items.remove(items.indexOf(getItem(productID)));
    update();
    if (!checkItemExist(productID)) {
        System.out.println("Item " + productID + " was successfuly deleted");
    } else {
       System.err.println("Item " + productID + " was not deleted");
    }
    }
     
    public boolean checkItemExist(int itmID){
    for (Item item : items){
        if (item.getProductID() == itmID) {
            return true;
        }
        
    }
    return false;
    }
    public Item getItem (int itmID) {
    if (checkItemExist(itmID)){
    Item item = new Item (itmID);
    int index= items.indexOf(item);
    return items.get(index);
    }
    else {
    return null;
    }
    }
    public void addProfileToCatalog(Item item) throws IOException {
    if (!checkItemExist(item.getProductID())){
    items.add(item);
    update();
    if (checkItemExist(item.getProductID())) {
    System.out.println("User was successfuly created");
     }
    else {
    System.err.println("user " + item.getProductID() + " was not created");
    }
    }
    else {
    System.err.println("User already exists");
    }
    }
    
}
