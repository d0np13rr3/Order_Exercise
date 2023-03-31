package com.example.order_exercise.controller;

import com.example.order_exercise.domain.ItemGroup;
import com.example.order_exercise.domain.Order;
import com.example.order_exercise.domain.UserOrders;
import com.example.order_exercise.service.*;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.List;

import static com.example.order_exercise.security.Feature.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final ItemService itemService;
    private final ItemGroupService itemGroupService;
    private final OrderService orderService;
    private final LoginService loginService;

    private final UserOrdersService userOrdersService;

    public OrderController(ItemService itemService, ItemGroupService itemGroupService, OrderService orderService, LoginService loginService, UserOrdersService userOrdersService) {
        this.itemService = itemService;
        this.itemGroupService = itemGroupService;
        this.orderService = orderService;
        this.loginService = loginService;
        this.userOrdersService = userOrdersService;
    }

    @GetMapping ("/{id}/order/{amountOrdered}")
    //make method in order to add found id in order
    public ItemGroup findbyId(@PathVariable int id, @PathVariable int amountOrdered){
        loginService.validateAction(loginService.getRole(), ORDER_BYID);
        return itemGroupService.create(itemService.findById(id), amountOrdered);
    }
    @GetMapping("/orderfindall")
    public List<ItemGroup> findAll(){
        loginService.validateAction(loginService.getRole(), ORDER_FINDALL);
        return itemGroupService.findAll();
    }

//    @GetMapping("/orderoverview")
//    public Order orderOverview(){
//        loginService.validateAction(loginService.getRole(), ORDER_OVERVIEW);
//        List<ItemGroup> itemGroups = itemGroupService.findAll();
//        ItemGroup[] itemGroupArray = new ItemGroup[itemGroups.size()];
//        int itr_Order = 0;
//        for(ItemGroup o : itemGroups){
//            Array.set(itemGroupArray, itr_Order, o);
//            itr_Order ++;
//        }
//        Order order = orderService.create(itemGroupArray);
//        order.setCustomerName("Pierre");
//        return order;
//    }

    @GetMapping("/userorderssave")
    public Order saveOrderToUserOrders(){
        loginService.validateAction(loginService.getRole(), ORDER_SAVETOUSERORDERS);
        List<ItemGroup> itemGroups = itemGroupService.findAll();
        ItemGroup[] itemGroupArray = new ItemGroup[itemGroups.size()];
        int itr_Order = 0;
        for(ItemGroup o : itemGroups){
            Array.set(itemGroupArray, itr_Order, o);
            itr_Order ++;
        }
        Order order = orderService.create(itemGroupArray);
//        order.setCustomerName("Pierre");
        userOrdersService.create(order);
        itemGroupService.delete();

        return order;

    }

    @GetMapping("/userordersseeall")
    public Collection<Order> findAllUsersOrders(){
        loginService.validateAction(loginService.getRole(), ORDER_SEEUSERORDERS);

        //order zit al in repo, naam naar hier verhuizen, totaal meegeven
        return userOrdersService.findAll();
    }
    @GetMapping("/userorders")
    public UserOrders showUserOrders(){
        loginService.validateAction(loginService.getRole(), ORDER_SEEUSERORDERS);
        return userOrdersService.overviewUserOrders();
    }




}
