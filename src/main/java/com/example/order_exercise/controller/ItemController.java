package com.example.order_exercise.controller;

import com.example.order_exercise.dto.CreateItemDTO;
import com.example.order_exercise.dto.ItemDTO;
import com.example.order_exercise.service.ItemService;
import com.example.order_exercise.service.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.order_exercise.security.Feature.*;


@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService service;
    private final LoginService loginService;

    public ItemController(ItemService service, LoginService loginService) {
        this.loginService = loginService;
        this.service = service;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDTO create(@RequestBody CreateItemDTO newItem){
        loginService.validateAction(loginService.getRole(), ITEM_CREATE);
        return service.create(newItem);
    }
    @GetMapping("/{id}")
    public ItemDTO findItemByID(@PathVariable("id") Integer id){
        loginService.validateAction(loginService.getRole(), ITEM_FINDBYID);
        return service.findById(id);
    }
    @GetMapping("/findall")
    public List<ItemDTO> findAll(){
        loginService.validateAction(loginService.getRole(), ITEM_FINDALL);
        return service.findAll();
    }
}
