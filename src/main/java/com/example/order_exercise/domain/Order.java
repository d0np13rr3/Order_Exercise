package com.example.order_exercise.domain;

public class Order {

    private ItemGroup[] itemGroupList;
    private Double totalPrice = 0.0;
    private Double price;
    private String customerName;

    public Order(ItemGroup... itemGroupList){
        this.price = calculateTotalPrice(itemGroupList);
        this.customerName = "";

    }

    private Double calculateTotalPrice(ItemGroup[] itemGroupList){
        for(ItemGroup o: itemGroupList){
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
