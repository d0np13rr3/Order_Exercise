package com.example.order_exercise.repository;

import com.example.order_exercise.domain.Amount;
import com.example.order_exercise.domain.Item;
import com.example.order_exercise.exceptions.IdNotFoundException;
import com.example.order_exercise.exceptions.ItemNotUniqueException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class ItemRepository {

    private static final Logger logger = LoggerFactory.getLogger(UserRepository.class);
    private static final HashMap<Integer, Item> repository = new HashMap<>();
    private static ArrayList<Integer> listOfId = new ArrayList<>();

    public ItemRepository (){
        Amount amount00 = new Amount(5);
        amount00.setInStock(true);
        Amount amount01 = new Amount(1);
        amount01.setInStock(true);
        Item dummyItem00 = new Item("Warhammer: Crimson Fists", "Novel", 15.0, amount00);
        Item dummyItem01 = new Item("Batman: The Long Halloween", "Graphic Novel", 25.0, amount01);
        Item dummyItem02 = new Item("The Dwarves: Triumph", "Novel", 10.0, amount00);
        logger.warn("Dummy00 item - only for debugging purposes " + dummyItem00.getName());
        logger.warn("Dummy01 item - only for debugging purposes " + dummyItem01.getName());
        logger.warn("Dummy02 item - only for debugging purposes " + dummyItem02.getName());
        dummyItem00.setId(0);
        dummyItem01.setId(1);
        dummyItem01.setId(2);
        repository.put(0, dummyItem00);
        repository.put(1, dummyItem01);
        repository.put(1, dummyItem02);
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
//        String itemName = "id: " + id + ". Name: " + item.getName();
//        item.setName(itemName);
        item.setId(id);
        repository.put(id, item);
        return item;
    }
    public Optional<Item> findById(Integer id){
        logger.warn(String.valueOf(Optional.ofNullable(repository.get(id)) + " error with findbyID"));
        if(!Optional.ofNullable(repository.get(id)).isPresent()) {
            throw new IdNotFoundException();
        }else {
            return Optional.ofNullable(repository.get(id));
        }
    }
    public Collection<Item> findAll(){
        return repository.values();
    }
    private void checkIfNameIsUnique(Item newItem) {
        if (this.repository.values().stream().map(Item::getName).anyMatch(email -> email.equals(newItem.getName()))){
            throw new ItemNotUniqueException();
        }
    }
    public Optional<Item> findByName(String name){
        Optional<Item> optionalItem = repository.entrySet().stream()
                .filter(e -> name.equals(e.getValue().getName()))
                .map(Map.Entry::getValue)
                .findFirst();
        return optionalItem;
    }
    public void changeAmountOfItemInRepository(Item item, Amount amount){
        for (Item item00 : repository.values()){
            if(item00.equals(item)){
                item00.setAmount(amount);
            }
        }
    }
    public void deleteItemsInItemRepository(){
        repository.clear();
    }


}
