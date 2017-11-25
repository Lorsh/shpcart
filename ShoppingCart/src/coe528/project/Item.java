package coe528.project;

import java.io.Serializable;

public class Item implements Serializable{

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
    
    @Override
    public String toString() {
        return "Name: "+name+ "\t\tPrice: "+price+"\t\tCondition: "+condition;
    }
}
