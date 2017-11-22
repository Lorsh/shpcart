package coe528.project;

import java.util.ArrayList;
import java.util.Calendar;

public class Order {
    static private int orderIDCounter= 0;
    
    private Calendar dateGen;  // date in which order was generated

    private Customer customer; 
    
    private ArrayList<Item> items;

    private int orderID;

    private OrderState currentState;

    private OrderState OverThreshold;

    private OrderState UnderThreshold;

    private double subTotal;

    private ShippingInfo shipInfo;

    private double totalCost;

    private Calendar expectedArrival;
    
     public Order() {
         this.orderID = orderIDCounter;
         orderIDCounter++;
         items = customer.getShopppingCart().getItems();
         
         
    }

    
    public void placeOrder() {
        
        
    }
    public double afterTax() {
        double m = ((1.13*(subTotal)));
        return m;
    }
    
    public OrderState setOrderState() {
       
    }

    public double calculateTotal() {
       
    }
}
