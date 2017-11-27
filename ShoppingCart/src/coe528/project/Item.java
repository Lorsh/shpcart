package coe528.project;

import java.io.Serializable;

public class Item implements Serializable{
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
     * c.name.length() > 0 && c.price >= 0 && (c.condition.equals("New") || c.condition.equals("Used"))
     * 
     */
    private String name;

    private String condition;

    private final int productID;

    private double price;
    
    private static int IDCounter = 0;

    public Item(String name, String condition, double price) {
        IDCounter++;
        this.name = name;
        this.condition = condition;
        this.productID = IDCounter;
        this.price = price;
    }
    
    public String getName() {
        return name;
    }

    public String getCondition() {
        return condition;
    }

    public int getProductID() {
        return productID;
    }

    public double getPrice() {
        return price;
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Item && ((Item)obj).getName() == this.name && ((Item)obj).getCondition() == this.condition){
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean repOK(){
        if(price >= 0 && (condition.equals("New") || condition.equals("Used")) && name.length() > 0){
            return true;
        }
        else{
            return false;
        }
    }
    
    @Override
    public String toString() {
        return "Name: "+name+ "\t\tPrice: "+price+"\t\tCondition: "+condition+"\t\tProduct ID: "+productID;
    }
}
