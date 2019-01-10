package com.kodilla.patterns.strategy.social;

public class ZGeneration extends User {
    public ZGeneration(String personName) {
        super(personName);
        this.socialPublisher = new SnapchatPublisher();
    }
}
