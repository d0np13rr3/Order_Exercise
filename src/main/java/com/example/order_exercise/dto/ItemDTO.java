package com.example.order_exercise.dto;

import com.example.order_exercise.domain.Amount;

import java.util.Objects;

public class ItemDTO {
    private final String name;
    private final String description;
    private final Double price;
    private final Amount amount;
    private final Integer id;

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

    public ItemDTO(String name, String description, Double price, Amount amount, Integer id) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemDTO itemDTO = (ItemDTO) o;
        return name.equals(itemDTO.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public Integer getId() {
        return id;
    }
}
