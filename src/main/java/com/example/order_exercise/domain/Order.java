package com.example.order_exercise.domain;

import com.example.order_exercise.dto.ItemDTO;

import java.time.LocalDate;

public class Order {
    private ItemDTO item;
    private int amountInOrder;
    private LocalDate shippingDate = LocalDate.now();

    public ItemDTO getItem() {
        return item;
    }

    public int getAmountInOrder() {
        return amountInOrder;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }

    public Order(ItemDTO item, int amountInOrder) {
        this.item = item;
        this.amountInOrder = amountInOrder;
        if(item.getAmount().isInStock()){
            this.shippingDate = shippingDate.plusDays(1);
        } else {
            this.shippingDate = shippingDate.plusDays(7);
        }


    }
}
