package coe528.project;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Order {
    static private int orderIDCounter= 0;
    
    private final String dateGen;  // date in which order was generated

    private Customer customer; 
    
    private final double threshold = 100;
    
    private final String datePattern = "yyyy-MM-dd";
    
    private final ArrayList<Item> items;

    private final int orderID;

    private final OrderState currentState;

    private OrderState OverThreshold;

    private OrderState UnderThreshold;

    private final double subtotal;

    private ShippingInfo shipInfo;

    private final double totalCost;

    private final String expectedArrival;
    
     public Order(ArrayList<Item> items, double subtotal) {
         this.customer = customer;
         this.orderID = orderIDCounter;
         orderIDCounter++;
         this.items = items;
         dateGen = calculateDateGen(DateTimeFormatter.ofPattern(datePattern));
         expectedArrival = calculateDateOfArrival(DateTimeFormatter.ofPattern(datePattern));
         this.subtotal = subtotal;
         currentState = (subtotal>threshold) ? OverThreshold : UnderThreshold;
         totalCost = calculateTotal(this.subtotal,items);
         
    }
     
    private String calculateDateGen(DateTimeFormatter formatter){
        return LocalDate.now().format(formatter);
    }
     
     
    private String calculateDateOfArrival(DateTimeFormatter formatter){
        return LocalDate.now().plusDays(7).format(formatter);
    }

    public String getDateGen() {
        return dateGen;
    }

    public int getOrderID() {
        return orderID;
    }

    public String getExpectedArrival() {
        return expectedArrival;
    }
    
    
    
    public double afterTax(double price) {
        double m = ((1.13*(price)));
        return m;
    }

    public double calculateTotal(double subtotal,ArrayList<Item> shippingCost) {
       return afterTax(currentState.calculateTotal(subtotal,shippingCost));
    }
    
    
}
