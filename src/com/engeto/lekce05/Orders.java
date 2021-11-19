package com.engeto.lekce05;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

import static java.util.Collections.*;


public class Orders {
    List<Order> orders = new ArrayList<>();

    public void add(Order order) {
        orders.add(order);
    }

    public int getNumberOfOrders() {
        return orders.size();
    }

    // TODO:
    public Map itemsNumOfPieces() {
        Map<String, Integer> itemsMap= new HashMap<>();
        String key;
        int quantity;
    for (Order order:orders){
        for (OrderItem item: order.getItems()){
            key=item.getTitle();
            quantity=0;
            if (!itemsMap.containsKey(key)) {
                quantity = item.getQuantity();
            } else quantity=item.getQuantity()+itemsMap.get(key);
            itemsMap.put(key, quantity);
        }
    }
    return itemsMap;
    }

    // TODO:
     public Map turnoverTotalPerDay() {
         Map<LocalDate, BigDecimal> turnoverMap= new HashMap<>();
         LocalDate date;
         BigDecimal price;
         for (Order order:orders){
             date=order.getDate();
             if (!turnoverMap.containsKey(date))
             price = order.totalPrice();
            else  price=order.totalPrice().add(turnoverMap.get(date));
            turnoverMap.put(date, price);
         }
         return turnoverMap;

     }


    // TODO:
    public List  itemsSoldAlphabetically() {

        List<String> titles = new ArrayList<>();
    for (Order order:orders){
        for (OrderItem item:order.getItems()){
            if (!titles.contains(item.getTitle()))
            titles.add(item.getTitle());
        }

Collections.sort(titles);


    }
    return titles;
    }





    //}

    // TODO:
    public Map ordersPerTable() {
        Map<Integer, Integer> numberOfOrders=new HashMap<>();
        for (int i=1; i<=8; i++) numberOfOrders.put(i, 0);
        for (Order order:orders){
            numberOfOrders.put(order.getTableNo(), numberOfOrders.get(order.getTableNo())+1);

        }

        return numberOfOrders;

    }


}