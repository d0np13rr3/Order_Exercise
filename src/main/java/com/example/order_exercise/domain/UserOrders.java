package com.example.order_exercise.domain;

import com.example.order_exercise.repository.LoginRepository;
import com.example.order_exercise.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserOrders {

    private Order[] orderGroupList;
    private Double orderGroupPrice = 0.0;

    public String getUserName() {
        return userName;
    }

    private String userName = "";

    private static final Logger logger = LoggerFactory.getLogger(UserRepository.class);

    public UserOrders(Order ... orderGroupList){
        this.orderGroupList = orderGroupList;
        this.orderGroupPrice = calculateTotalPrice(orderGroupList);
        this.userName = LoginRepository.getNameUser();
        logger.warn("OrderPrice 00 - in Constructor "+ orderGroupPrice);

    }

    private Double calculateTotalPrice(Order[] orderGroupList){
        logger.warn("OrderPrice 01 - in Calculator before for "+ orderGroupPrice);
        for(Order o: orderGroupList){
            orderGroupPrice = orderGroupPrice + o.getPrice();
            logger.warn("OrderPrice 02 - in Calculator in for "+ orderGroupPrice);
        }
        logger.warn("OrderPrice 03 - in Calculator after for "+ orderGroupPrice);
        return orderGroupPrice;
    }

    public Double getOrderGroupPrice() {
        return orderGroupPrice;
    }

    public Order[] getOrderGroupList() {
        return orderGroupList;
    }
}
