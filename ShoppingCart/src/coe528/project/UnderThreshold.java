package coe528.project;

import java.util.ArrayList;

public class UnderThreshold implements OrderState {

    double shippingCost  = 0;
    public double calculateShipping(double subtotal,ArrayList<Item> items) {
        int counter=0;
        shippingCost = 0;
        for (Item x : items) {
            counter++;
        }
        if (counter <= 2) {
            shippingCost = 25;
        }
        else if (counter <= 4) {
            shippingCost = 50;
        }
        else {
        for (Item x : items) {
            shippingCost += 10;
        }    
            
        }
        
        return shippingCost;
        
    }
    
    public String toString(){
        String truncated = (String ) String.format("%.2f",shippingCost );
        return "Does not qualify for free shipping!\nShipping Cost: " + truncated + "\n" ;
    }
}
