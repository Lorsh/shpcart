package coe528.project;

public class Item {

    private String name;

    private String condition;

    private final int productID;

    private double price;

    public Item(String name, String condition, int productID, double price) {
        this.name = name;
        this.condition = condition;
        this.productID = productID;
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
        return "Name:\t\t"+name+"\n" + "Price:\t\t"+price+"\n" + "Condition: \t\t"+condition+"\n" + "Product ID:\t\t"+productID+"\n";
    }
}
