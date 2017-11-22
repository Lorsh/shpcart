package coe528.project;

import java.util.ArrayList;

public class UnderThreshold implements OrderState {

    private OrderState state;

    public double calculateTotal(double subtotal,ArrayList<Item> items) {
        int counter=0;
        double shippingCost = 0;
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
        
        return subtotal + shippingCost;
        
    }
    
}
