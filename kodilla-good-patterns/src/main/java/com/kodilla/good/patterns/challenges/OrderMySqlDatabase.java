package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public class OrderMySqlDatabase {
    public boolean saveOrder(User user, LocalDateTime orderDate) {
        System.out.println("Order placed by " + user.toString() + " on " + orderDate + " has been saved.");
        return true;
    }
}
