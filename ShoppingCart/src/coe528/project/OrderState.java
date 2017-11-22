package coe528.project;

import java.util.ArrayList;

public interface OrderState {

    public double calculateTotal(double subtotal,ArrayList<Item> items);
}
