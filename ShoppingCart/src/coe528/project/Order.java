package coe528.project;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * 
 */
public class Order {

    static private int orderIDCounter= 0;
    
    private final String dateGen;  // date in which order was generated

    private final double threshold = 100;
    
    private final String datePattern = "yyyy-MM-dd";
    
    private final ArrayList<Item> items;

    private final int orderID;

    private final OrderState currentState;

    private OrderState OverThreshold = new OverThreshold();

    private OrderState UnderThreshold = new UnderThreshold();

    private final double subtotal;

    final private ShippingInfo shipInfo;

    private final double totalCost;

    private final double shippingCost;
    
    private final double taxCost;
    
    private final String expectedArrival;
    
     public Order(ArrayList<Item> items, double subtotal,ShippingInfo shipInfo) {
         this.orderID = orderIDCounter;
         orderIDCounter++;
         this.items = items;
         dateGen = calculateDateGen(DateTimeFormatter.ofPattern(datePattern));
         expectedArrival = calculateDateOfArrival(DateTimeFormatter.ofPattern(datePattern));
         this.subtotal = subtotal;
         this.shipInfo = shipInfo;

         currentState = (subtotal>threshold) ? OverThreshold : UnderThreshold;
         shippingCost = calculateShipping(this.subtotal,items);
         double afterShipping = this.shippingCost + this.subtotal;
         taxCost = calculateTax(subtotal);
         totalCost = taxCost + afterShipping;
         
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
    
    
    
    public double calculateTax(double price) {
        double m = ((0.13*(price)));
        return m;
    }

    public double calculateShipping(double subtotal,ArrayList<Item> shippingCost) {
       return currentState.calculateShipping(subtotal,shippingCost);
    }
    
    @Override
    public String toString(){
        String header = "---------------------Order Summary---------------------\n";
        String footer = "-------------------------------------------------------\n";
        String output = header + shipInfo.toString() + "\n";
        for (Item x : items) {
            output = output.concat(x.toString() + "\n");
        }
        output = output.concat(currentState.toString() + "\n");
        String truncated_taxCost = (String ) String.format("%.2f",taxCost );
        output = output.concat("Tax: "  + truncated_taxCost + "\n");
        String truncated_totalCost = (String ) String.format("%.2f",totalCost );
        output = output.concat("Total cost: "  + truncated_totalCost + "\n");
        output = output.concat(footer);
        return output;
    }
    
}
