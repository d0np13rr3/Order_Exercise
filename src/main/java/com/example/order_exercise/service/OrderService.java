package com.example.order_exercise.service;

import com.example.order_exercise.domain.Amount;
import com.example.order_exercise.domain.Item;
import com.example.order_exercise.domain.Order;
import com.example.order_exercise.dto.ItemDTO;
import com.example.order_exercise.exceptions.AmountNotCorrectException;
import com.example.order_exercise.exceptions.ItemNotFoundException;
import com.example.order_exercise.exceptions.StockNotCorrectException;
import com.example.order_exercise.mapper.ItemMapper;
import com.example.order_exercise.repository.CustomerRepository;
import com.example.order_exercise.repository.ItemRepository;
import com.example.order_exercise.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository repository;
    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;
    private static final Logger logger = LoggerFactory.getLogger(CustomerRepository.class);
    public OrderService(OrderRepository repository, ItemRepository itemRepository, ItemMapper itemMapper) {
        this.repository = repository;
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }
    public List<Order> findAll() {
        return repository.findAll()
                .stream()
                .toList();
    }

    public Order create(ItemDTO item, int amountInOrder) {
        Order newOrder = new Order(item, amountInOrder);
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
            return repository.create(item, newOrder);
        }
    }
}
