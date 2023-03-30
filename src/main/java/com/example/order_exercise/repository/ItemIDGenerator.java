package com.example.order_exercise.repository;

import java.util.ArrayList;

public class ItemIDGenerator {
    private static ArrayList<Integer>OrderIdMap = new ArrayList<>();

    private int generatedID;

    public static int getNextID(){
        ArrayList<Integer> idPresentInRepo = ItemRepository.getIdOfRepository();
        int i;
        for(i = 0; i < idPresentInRepo.size(); i++){
        }
        return i;
    }

    public static int getNextIDOrder(){
        int o;
        for(o = 0; o < OrderIdMap.size(); o++){
            OrderIdMap.add(o);
        }
        return o;
    }

}
