package com.example.order_exercise.service;

import com.example.order_exercise.domain.Amount;
import com.example.order_exercise.domain.Item;
import com.example.order_exercise.domain.ItemGroup;
import com.example.order_exercise.dto.ItemDTO;
import com.example.order_exercise.exceptions.ItemNotFoundException;
import com.example.order_exercise.exceptions.StockNotCorrectException;
import com.example.order_exercise.mapper.ItemMapper;
import com.example.order_exercise.repository.UserRepository;
import com.example.order_exercise.repository.ItemRepository;
import com.example.order_exercise.repository.ItemGroupRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemGroupService {
    private final ItemGroupRepository repository;
    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;
    private static final Logger logger = LoggerFactory.getLogger(UserRepository.class);
    public ItemGroupService(ItemGroupRepository repository, ItemRepository itemRepository, ItemMapper itemMapper) {
        this.repository = repository;
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }
    public List<ItemGroup> findAll() {
        return repository.findAll()
                .stream()
                .toList();
    }

    public ItemGroup create(ItemDTO item, int amountInOrder) {
        ItemGroup newItemGroup = new ItemGroup(item, amountInOrder);
        Optional<Item> optionalItem = itemRepository.findByName(item.getName());

        logger.warn(String.valueOf(Optional.ofNullable(itemRepository.findByName(item.getName() + " error with create order"))));
        if(!optionalItem.isPresent()) {
            throw new ItemNotFoundException();
        }

        int initialStock = optionalItem.get().getAmount().getAmount();

        int newStock = initialStock - amountInOrder;
        if(newStock<0){
            throw new StockNotCorrectException();
        }else {
            Amount newAmount = new Amount(newStock);

            if(newStock == 0){
                newAmount.setInStock(false);
            }else{
                newAmount.setInStock(true);
            }
            itemRepository.changeAmountOfItemInRepository(optionalItem.get(), newAmount);
            return repository.create(item, newItemGroup);
        }
    }
}
