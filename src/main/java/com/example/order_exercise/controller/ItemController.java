package com.example.order_exercise.controller;

import com.example.order_exercise.dto.CreateCustomerDTO;
import com.example.order_exercise.dto.CreateItemDTO;
import com.example.order_exercise.dto.CustomerDTO;
import com.example.order_exercise.dto.ItemDTO;
import com.example.order_exercise.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService service;

    public ItemController(ItemService service) {
        this.service = service;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDTO create(@RequestBody CreateItemDTO newItem){
        return service.create(newItem);
    }
    @GetMapping("/{id}")
    public ItemDTO findItemByID(@PathVariable("id") Integer id){
        return service.findById(id);
    }
    @GetMapping("/findall")
    public List<ItemDTO> findAll(){
        return service.findAll();
    }
}
