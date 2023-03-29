package com.example.order_exercise.domain;

public class Item {
    private final String name;
    private final String description;
    private final Double price;
    private Amount amount;

    public Item(String name, String description, Double price, Amount amount) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public Amount getAmount() {
        return amount;
    }

    public Item setAmount(Amount amount){
        this.amount = amount;
        return this;
    }
}
