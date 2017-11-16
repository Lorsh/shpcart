package coe528.project;

import java.util.Calendar;

public class Order {

    private int order;

    private Calendar dataGen;

    private Customer customer;

    private ShoppingCart cart;

    private String status;

    public Order() {
    }

    public void placeOrder() {
    }

    private int orderID;

    private OrderState currentState;

    private OrderState OverThreshold;

    private OrderState UnderThreshold;

    private double subTotal;

    private ShippingInfo shipInfo;

    private double totalCost;

    private Calendar expectedArrival;

    private OrderState noShippingInfo;

    public OrderState setOrderState() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public double calculateTotal() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
