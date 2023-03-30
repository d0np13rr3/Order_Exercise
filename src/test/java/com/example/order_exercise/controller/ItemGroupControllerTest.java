package com.example.order_exercise.controller;

import com.example.order_exercise.domain.Amount;
import com.example.order_exercise.domain.ItemGroup;
import com.example.order_exercise.dto.ItemDTO;
import com.example.order_exercise.exceptions.ItemNotFoundException;
import com.example.order_exercise.exceptions.StockNotCorrectException;
import com.example.order_exercise.mapper.ItemMapper;
import com.example.order_exercise.repository.ItemRepository;
import com.example.order_exercise.repository.LoginRepository;
import com.example.order_exercise.repository.ItemGroupRepository;
import com.example.order_exercise.security.Role;
import com.example.order_exercise.service.ItemGroupService;
import com.example.order_exercise.service.ItemService;
import com.example.order_exercise.service.LoginService;
import com.example.order_exercise.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ItemGroupControllerTest {

    private ItemGroupController controller;
    private ItemGroupRepository itemGroupRepository = new ItemGroupRepository();
    private ItemRepository itemRepository = new ItemRepository();
    private ItemGroupService itemGroupService = new ItemGroupService(itemGroupRepository, itemRepository, new ItemMapper());

    private LoginRepository loginRepository = new LoginRepository();
    private LoginService loginService = new LoginService(loginRepository);

    @BeforeEach
    void setup(){
        controller = new ItemGroupController(new ItemService(new ItemMapper(), new ItemRepository()), itemGroupService, new OrderService(), loginService);
    }

    @Test
    @DisplayName("Did we find all orders?")
    void findAllOrders(){
        loginService.setRole(Role.CUSTOMER);
        List<ItemGroup> answer = controller.findAll();
        assertThat(answer).hasSize(1);
    }

    @Test
    @DisplayName("Did order creation fail @ no Item Present?")
    void failingOrderNotThere(){
        loginService.setRole(Role.CUSTOMER);
        Amount amount00 = new Amount(1);
        ItemDTO dummyItem02 = new ItemDTO("The Dwarves: Triumph", "Novel", 10.0, amount00, 4);

        Throwable exception = assertThrows(ItemNotFoundException.class, () ->
                itemGroupService.create(dummyItem02, 10));
        assertEquals("Item not found. Try an existing item.", exception.getMessage());
    }

    @Test
    @DisplayName("Did order creation fail @ to much ordered?")
    void failingOrderToMuch(){
        loginService.setRole(Role.CUSTOMER);
        Amount amount00 = new Amount(1);
        ItemDTO dummyItem02 = new ItemDTO("Warhammer: Crimson Fists", "Novel", 15.0,amount00, 0);

        Throwable exception = assertThrows(StockNotCorrectException.class, () ->
            itemGroupService.create(dummyItem02, 10));
        assertEquals("You are ordering to much, make your wanted total smaller.", exception.getMessage());
    }



}