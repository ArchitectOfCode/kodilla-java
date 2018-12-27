package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public class OrderDbMySql implements OrderRepository {
    public boolean createOrder(User user, LocalDateTime orderDate) {
        System.out.println("Order made by " + user + " on " + orderDate + " has been stored.");
        return true;
    }
}
