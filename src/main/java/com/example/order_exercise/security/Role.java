package com.example.order_exercise.security;

import java.util.ArrayList;
import java.util.List;
import com.example.order_exercise.security.Feature;

import static com.example.order_exercise.security.Feature.*;
import static com.google.common.collect.Lists.newArrayList;

public enum Role {
    DEFAULT(newArrayList()),
    ADMIN(newArrayList(CUSTOMER_FINDALL, CUSTOMER_FINDBYID, CUSTOMER_CREATE, ITEM_CREATE, ITEM_FINDBYID, ITEM_FINDALL)),
    CUSTOMER(newArrayList(ORDER_BYID, ORDER_FINDALL, ORDER_OVERVIEW, ORDER_SAVETOUSERORDERS, ORDER_SEEUSERORDERS));

    Role(ArrayList<Feature> featureList) {
        this.featureList = featureList;
    }
    private final List<Feature> featureList;

    public boolean containsFeature(Feature feature){
        return featureList.contains(feature);
    }
}
