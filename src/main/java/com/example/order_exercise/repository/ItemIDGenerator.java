package com.example.order_exercise.repository;

import java.util.ArrayList;

public class ItemIDGenerator {

    private int generatedID;

    public static int getNextID(){
        ArrayList<Integer> idPresentInRepo = ItemRepository.getIdOfRepository();
        int i;
        for(i = 0; i < idPresentInRepo.size(); i++){
        }
        return i;

    }
}
