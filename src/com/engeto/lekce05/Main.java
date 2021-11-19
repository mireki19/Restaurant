package com.engeto.lekce05;


import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    private static Orders orders = new Orders();

    public static void prepareData() {
        try {
            Order order;
            order = new Order(1, LocalDate.of(2021, 05, 20), PaymentType.CASH);
            order.addItem(new OrderItem("Caesar salát", 150, 2));
            order.addItem(new OrderItem("Big Burger", 350, 1));
            order.addItem(new OrderItem("Mattoni", 30, 3));
            orders.add(order);
            order = new Order(5, LocalDate.of(2021, 05, 18), PaymentType.CARD);
            order.addItem(new OrderItem("Big Burger", 350, 2));
            order.addItem(new OrderItem("Kofola velká", 30, 2));
            orders.add(order);
            order = new Order(1, LocalDate.of(2021, 05, 20), PaymentType.CARD);
            order.addItem(new OrderItem("Svíčková na smetaně", 220, 1));
            order.addItem(new OrderItem("Big Burger", 350, 1));
            order.addItem(new OrderItem("Smažený hermelín", 135, 1));
            order.addItem(new OrderItem("Palačinky s jahodami", 160, 1));
            order.addItem(new OrderItem("Mattoni", 30, 2));
            order.addItem(new OrderItem("Malinovka domácí", 45, 2));
            orders.add(order);
            order = new Order(2, LocalDate.of(2021, 05, 18), PaymentType.CARD);
            order.addItem(new OrderItem("Smažený hermelín", 135, 3));
            order.addItem(new OrderItem("Malinovka domácí", 45, 3));
            orders.add(order);
        } catch (OrdersException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        prepareData();

        // 3. Na základě názvu položky spočítejte celkový počet kusů dané položky, které jsme prodali:
        System.out.println(orders.itemsNumOfPieces());

        // 4. Spočítejte celkový obrat (turnover) ze všech objednávek za jednotlivé dny:
        System.out.println(orders.turnoverTotalPerDay());

        // 5. Připravte metodu, která získá výpis všech názvů položek,
        //  které byly objednány.
        //  Pokud byla položka objednána vícekrát, ve výpisu bude jen jednou.
        //  Položky ve výpisu budou seřazené podle abecedy.
        // TODO:
        System.out.println(orders.itemsSoldAlphabetically());

        // 6. Vypište počet objednávek pro jednotlivé stoly.
        // TODO: ??? ordersPerTable = orders.ordersPerTable();
        System.out.println("Počet objednávek u jednotlivých stolů:");
        // TODO: Je třeba vypsat:

        System.out.println(orders.ordersPerTable());
        // ...
    }
}