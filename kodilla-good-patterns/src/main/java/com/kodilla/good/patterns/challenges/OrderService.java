package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public interface OrderService {
    public boolean getOrder(User user, LocalDateTime orderDate);
}
