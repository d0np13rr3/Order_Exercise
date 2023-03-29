package com.example.order_exercise.repository;

import com.example.order_exercise.domain.Amount;
import com.example.order_exercise.domain.Customer;
import com.example.order_exercise.domain.Item;
import com.example.order_exercise.exceptions.ItemNotUniqueException;
import com.example.order_exercise.exceptions.MemberNotUniqueException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class ItemRepository {

    private static final Logger logger = LoggerFactory.getLogger(CustomerRepository.class);
    private static final HashMap<Integer, Item> repository = new HashMap<>();
    private static ArrayList<Integer> listOfId = new ArrayList<>();

    public ItemRepository (){
        Amount amount00 = new Amount(5);
        amount00.setInStock(true);
        Amount amount01 = new Amount(1);
        amount01.setInStock(true);
        Item dummyItem00 = new Item("Warhammer: Crimson Fists", "Novel", 15.0, amount00);
        Item dummyItem01 = new Item("Batman: The Long Halloween", "Graphic Novel", 25.0, amount01);
        logger.warn("Dummy00 item - only for debugging purposes " + dummyItem00.getName());
        logger.warn("Dummy00 item - only for debugging purposes " + dummyItem01.getName());
        repository.put(0, dummyItem00);
        repository.put(1, dummyItem01);
    }

    public static ArrayList<Integer> getIdOfRepository(){
        listOfId = (ArrayList<Integer>) repository.entrySet()
                .stream()
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        return listOfId;

    }
    public Item create(Item item) {
        checkIfNameIsUnique(item);
        int id = ItemIDGenerator.getNextID();
        repository.put(id, item);
        return item;
    }

    public Item findById(Integer id){
        return repository.get(id);
    }

    public Collection<Item> findAll(){
        return repository.values();
    }

    private void checkIfNameIsUnique(Item newItem) {
        if (this.repository.values().stream().map(Item::getName).anyMatch(email -> email.equals(newItem.getName()))){
            throw new ItemNotUniqueException();
        }

    }


}
