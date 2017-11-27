package coe528.project;

import java.io.Serializable;

/**
 * Overview: Item holds various fields of information that define a product
 * in the store of an order or a customer.  The condition must be "New" or
 * "Used". The price cannot be negative. The name must be more than the
 * 0 string. It is immutable.
 * 
 * Abstraction Function:
 * AF(c): A series of fields indicating name, condition, price, and 
 * product ID of product in the store.
 * 
 * The rep invariant is:
 * c.name.length() greater than 0 AND c.price greater than or equal to 0 AND (c.condition.equals("New") OR c.condition.equals("Used"))
 */
public class Item implements Serializable{
    
    private String name;

    private String condition;

    private final int productID;

    private double price;
    
    private static int IDCounter = 0;

    /**
     * MODIFES: name, condition, productID, price, IDCounter
     * EFFECTS: initializes name, condition and price. IDCounter is incremented by 1, and productID is initialized to IDCounter
     * @param name
     * @param condition
     * @param price 
     */
    public Item(String name, String condition, double price) {
        IDCounter++;
        this.name = name;
        this.condition = condition;
        this.productID = IDCounter;
        this.price = price;
    }
    
    /**
     * MODIFIES: none
     * EFFECTS: returns the String instance name
     * @return 
     */
    public String getName() {
        return name;
    }

    /**
     * MODIFES: none
     * EFFECTS: returns the String instance condition
     * @return 
     */
    public String getCondition() {
        return condition;
    }
    
    /**
     * MODIFIES: none
     * EFFECTS: returns the int instance productID
     * @return 
     */
    public int getProductID() {
        return productID;
    }
    
    /**
     * MODIFIES: none
     * EFFECTS: returns the double instance price
     * @return 
     */
    public double getPrice() {
        return price;
    }
    
    /**
     * MODIFIES: none
     * EFFECTS: returns true if obj's name and condition are not equal
     * @param obj
     * @return 
     */
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Item && ((Item)obj).getName() == this.name && ((Item)obj).getCondition() == this.condition){
            return true;
        }
        else{
            return false;
        }
    }
    /**
     * MODIFIES: none
     * EFFECTS: returns true if the rep invariant holds for this object; otherwise returns false
     * @return 
     */
    public boolean repOK(){
        if(price >= 0 && (condition.equals("New") || condition.equals("Used")) && name.length() > 0){
            return true;
        }
        else{
            return false;
        }
    }
    
    /**
     * MODIFIES: none
     * EFFECTS: returns a String containing the name, price, condition, and product ID of the object.
     * @return 
     */
    @Override
    public String toString() {
        return "Name: "+name+ "\t\tPrice: "+price+"\t\tCondition: "+condition+"\t\tProduct ID: "+productID;
    }
}
