package com.example.order_exercise.controller;

import com.example.order_exercise.domain.Item;
import com.example.order_exercise.dto.CreateItemDTO;
import com.example.order_exercise.dto.ItemDTO;
import com.example.order_exercise.service.ItemService;
import com.example.order_exercise.service.LoginService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import io.swagger.v3.core.util.Json;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PatchMapping(value = "/{id}/patch", consumes = "application/json-patch+json")
    public ResponseEntity<Item> updateItem(@PathVariable String id, @RequestBody JsonPatch patch) throws JsonPatchException, JsonProcessingException {
        loginService.validateAction(loginService.getRole(), ITEM_PATCH);
        Item item = service.findItemById(Integer.valueOf(id));
        Item itemPatched = applyPatchToItem(patch, item);
        return ResponseEntity.ok(itemPatched);
    }
    // Example of Patch[{"op":"replace","path":"/description","value":"Graphic Novel"}]
    private Item applyPatchToItem(JsonPatch patch, Item targetItem) throws JsonPatchException, JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode patched = patch.apply(objectMapper.convertValue(targetItem, JsonNode.class));
        return objectMapper.treeToValue(patched, Item.class);
    }
}
