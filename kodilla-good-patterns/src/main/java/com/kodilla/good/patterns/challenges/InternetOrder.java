package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public class InternetOrder implements OrderService {
    private User user;
    private LocalDateTime orderDate;

    public InternetOrder(User user, LocalDateTime orderDate) {
        this.user = user;
        this.orderDate = orderDate;
    }

    public boolean getOrder(User user, LocalDateTime orderDate) {
        this.toString();
        return true;
    }

    @Override
    public String toString() {
        return "InternetOrder{" +
                "user=" + user +
                ", orderDate=" + orderDate +
                '}';
    }
}
