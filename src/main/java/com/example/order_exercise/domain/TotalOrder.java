package com.example.order_exercise.domain;

public class TotalOrder {

    private Order[] orderList;
    private Double totalPrice = 0.0;
    private Double price;
    private String customerName;

    public TotalOrder(Order ... orderList){
        this.price = calculateTotalPrice(orderList);
        this.customerName = "";

    }

    private Double calculateTotalPrice(Order[] orderList){
        for(Order o: orderList){
            totalPrice = totalPrice + o.getItem().getPrice() * o.getAmountInOrder();
        }
        return totalPrice;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Double getPrice() {
        return price;
    }

    public String getCustomerName() {
        return customerName;
    }
}
