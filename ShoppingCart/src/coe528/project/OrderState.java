package coe528.project;

import java.util.ArrayList;

public interface OrderState {

    public double calculateShipping(double subtotal,ArrayList<Item> items);
}
