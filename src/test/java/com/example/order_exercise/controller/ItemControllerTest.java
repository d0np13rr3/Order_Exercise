package com.example.order_exercise.controller;

import com.example.order_exercise.dto.ItemDTO;
import com.example.order_exercise.exceptions.IdNotFoundException;
import com.example.order_exercise.mapper.ItemMapper;
import com.example.order_exercise.repository.ItemRepository;
import com.example.order_exercise.repository.LoginRepository;
import com.example.order_exercise.service.ItemService;
import com.example.order_exercise.service.LoginService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ItemControllerTest {
    private ItemController controller;
    @BeforeEach
    void setUp(){
        controller = new ItemController(new ItemService(new ItemMapper(), new ItemRepository()), new LoginService(new LoginRepository()));
    }

    @Test
    @DisplayName("Did we find all items?")
    void findItems(){
        List<ItemDTO> answer = controller.findAll();
        assertThat(answer).hasSize(2);
    }


    @Test
    @DisplayName("Is error thrown when wrong id given?")
    public void testWrongID() {
        Throwable exception = assertThrows(IdNotFoundException.class, () ->
            controller.findItemByID(5));
        assertEquals("Id not found. Try an existing id.", exception.getMessage());
    }


}