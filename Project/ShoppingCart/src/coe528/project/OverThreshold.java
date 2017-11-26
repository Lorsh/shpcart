package coe528.project;

import java.util.ArrayList;

public class OverThreshold implements OrderState {

    double shippingCost= 0;
    public double calculateShipping(double subtotal,ArrayList<Item> items) {
        return shippingCost;
    }
    public String toString() {
        return "Qualified for Free shipping!\nShipping Cost : " + shippingCost + "\n";
    }
}
