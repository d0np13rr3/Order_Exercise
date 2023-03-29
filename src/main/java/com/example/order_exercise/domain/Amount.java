package com.example.order_exercise.domain;

import com.example.order_exercise.exceptions.AmountNotCorrectException;
import com.example.order_exercise.exceptions.MemberNotUniqueException;

public class Amount {
    private int amount;
    private boolean inStock;

    public Amount(int amount) {
        this.amount = amount;
        this.inStock = inStock;
    }

    public Amount(){
        this.amount = amount;
        this.inStock = inStock;
    }

    public void setAmount(int amount) {
        if(amount < 0){
            throw new AmountNotCorrectException();
        }
        this.amount = amount;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public int getAmount() {
        return amount;
    }

    public boolean isInStock() {
        return inStock;
    }
}
