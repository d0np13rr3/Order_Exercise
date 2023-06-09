package com.example.order_exercise.domain;

import com.example.order_exercise.dto.ItemDTO;

import java.time.LocalDate;

public class ItemGroup {
    private ItemDTO item;
    private int amountInOrder;
    private LocalDate shippingDate = LocalDate.now();

    public ItemGroup(ItemDTO item, int amountInOrder) {
        this.item = item;
        this.amountInOrder = amountInOrder;
        if(item.getAmount().isInStock()){
            this.shippingDate = shippingDate.plusDays(1);
        } else {
            this.shippingDate = shippingDate.plusDays(7);
        }
    }

    public int getAmountInOrder() {
        return amountInOrder;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }

    public ItemDTO getItem() {
        return item;
    }
}
