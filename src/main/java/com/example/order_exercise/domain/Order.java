package com.example.order_exercise.domain;

import static com.example.order_exercise.repository.ItemIDGenerator.getNextIDOrder;

public class Order {

    private ItemGroup[] itemGroupList;
    private Double totalPrice = 0.0;
    private Double price;
    private String customerName;
    //definitions to add
    private Integer idOfOrder;
    private String allItemGroups;


    public Order(ItemGroup... itemGroupList){
        this.price = calculateTotalPrice(itemGroupList);
        this.customerName = "";
        this.idOfOrder = getNextIDOrder();
        this.allItemGroups = defineItemGroupsStatement(itemGroupList);

    }

    private Double calculateTotalPrice(ItemGroup[] itemGroupList){
        for(ItemGroup o: itemGroupList){
            totalPrice = totalPrice + o.getItem().getPrice() * o.getAmountInOrder();
        }
        return totalPrice;
    }

    private String defineItemGroupsStatement(ItemGroup[] itemGroupList){
        String ItemGroups = "";
        for(ItemGroup o: itemGroupList){
            ItemGroups = ItemGroups + "Title: " + o.getItem().getName() + ". Amount: " + o.getAmountInOrder() + ". Price itemgroup: " + (Double) o.getItem().getPrice() * (int)o.getAmountInOrder()  + ". ||| ";
        }return ItemGroups;

    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Double getPrice() {
        return price;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Integer getIdOfOrder() {
        return idOfOrder;
    }

    public String getAllItemGroups() {
        return allItemGroups;
    }


}
