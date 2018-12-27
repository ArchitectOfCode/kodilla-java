package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public interface OrderRepository {
    public boolean createOrder(User user, LocalDateTime orderDate);
}
