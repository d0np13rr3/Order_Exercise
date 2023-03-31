package com.example.order_exercise.service;

import com.example.order_exercise.domain.ItemGroup;
import com.example.order_exercise.service.ItemGroupService.*;
import com.example.order_exercise.domain.Order;
import com.example.order_exercise.exceptions.NoItemInOrderException;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.List;

@Service
public class OrderService {

    private final ItemGroupService itemGroupService;

    public OrderService(ItemGroupService itemGroupService) {
        this.itemGroupService = itemGroupService;
    }

    public Order create(ItemGroup... itemGroupList){
        Order order = new Order(itemGroupList);
        return order;
    }

    public Order createArray(){
        List<ItemGroup> itemGroups = itemGroupService.findAll();
        if(itemGroups.size() == 0){
            throw new NoItemInOrderException();
        }
        ItemGroup[] itemGroupArray = new ItemGroup[itemGroups.size()];
        int itr_Order = 0;
        for(ItemGroup o : itemGroups){
            Array.set(itemGroupArray, itr_Order, o);
            itr_Order ++;
        }
        Order order = create(itemGroupArray);
        return order;

    }
}
