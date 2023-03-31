package com.example.order_exercise.repository;

import java.util.ArrayList;

public class ItemIDGenerator {
    private static ArrayList<Integer>OrderIdMap = new ArrayList<>();

    private static int generatedID;

    public static int getNextID(){
        ArrayList<Integer> idPresentInRepo = ItemRepository.getIdOfRepository();
        int i;
        for(i = 0; i < idPresentInRepo.size(); i++){
        }
        return i;
    }

    public static int getNextIDOrder(){
        int currentId = OrderIdMap.size();
        for(int o = currentId; o < currentId + 1; o++){
            OrderIdMap.add(o);
            generatedID = o;
        }
        return generatedID;
    }

}
