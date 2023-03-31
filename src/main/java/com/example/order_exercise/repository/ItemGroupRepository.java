package com.example.order_exercise.repository;

import com.example.order_exercise.domain.Amount;
import com.example.order_exercise.domain.ItemGroup;
import com.example.order_exercise.dto.ItemDTO;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ItemGroupRepository {

    private static final HashMap<String, ItemGroup> repository = new HashMap<>();
    public ItemGroupRepository(){
        Amount amount00 = new Amount(5);
        amount00.setInStock(true);
        ItemDTO dummyItem02 = new ItemDTO("The Dwarves: Triumph", "Novel", 10.0, amount00, 2);
        ItemGroup itemGroup00 = new ItemGroup(dummyItem02, 2);
        repository.put(dummyItem02.getName(), itemGroup00);
    }
    public Collection<ItemGroup> findAll(){
        return repository.values();
    }

    public ItemGroup create(ItemDTO item, ItemGroup itemGroup) {
        repository.put(item.getName(), itemGroup);
        return itemGroup;
    }
    public void deleteItemgroupsInItemGroupRepository(){
        repository.clear();
    }
    public ItemGroup updateAmountInOrder(ItemDTO item, ItemGroup group){
        repository.replace(item.getName(), group);
        return group;
    }
    public boolean checkIfItemIsInRepo(ItemDTO item){
        boolean booleanToReturn = false;
        for(String key : repository.keySet()){
            if(key == item.getName()){
                booleanToReturn = true;
            }
        }
        return booleanToReturn;
    }
    public int getAmountInOrder(ItemDTO item){
        int inOrder = 0;
        for(Map.Entry<String, ItemGroup> item00 : repository.entrySet()){
            if(item00.getKey() == item.getName()){
                inOrder = item00.getValue().getAmountInOrder();
            }

        }return inOrder;
    }


    }


