package com.example.order_exercise.service;

import com.example.order_exercise.domain.Customer;
import com.example.order_exercise.domain.Item;
import com.example.order_exercise.dto.CreateItemDTO;
import com.example.order_exercise.dto.CustomerDTO;
import com.example.order_exercise.dto.ItemDTO;
import com.example.order_exercise.mapper.ItemMapper;
import com.example.order_exercise.repository.ItemRepository;
import com.example.order_exercise.security.Role;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class ItemService {

    private final ItemMapper mapper;
    private final ItemRepository repository;

    public ItemService(ItemMapper mapper, ItemRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }
    public List<ItemDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    public ItemDTO findById(Integer id) {
        return mapper.toDTO(repository.findById(id));
    }
    public ItemDTO create(CreateItemDTO newItem) {
        Item itemToSave = mapper.toDomain(newItem);
        return mapper.toDTO(repository.create(itemToSave));
    }

}
