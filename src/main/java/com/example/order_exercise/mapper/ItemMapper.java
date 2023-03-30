package com.example.order_exercise.mapper;

import com.example.order_exercise.domain.Item;
import com.example.order_exercise.dto.CreateItemDTO;
import com.example.order_exercise.dto.ItemDTO;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {

    public ItemDTO toDTO(Item item){
        return new ItemDTO(item.getName(), item.getDescription(), item.getPrice(), item.getAmount(), item.getId());
    }

    public Item toDomain(CreateItemDTO itemDTO){
        //return new Item(itemDTO.getName(), itemDTO.getDescription(), itemDTO.getPrice(), itemDTO.getAmount(), (Integer) itemDTO.getId());
        return new Item(itemDTO.getName(), itemDTO.getDescription(), itemDTO.getPrice(), itemDTO.getAmount());
    }
}
