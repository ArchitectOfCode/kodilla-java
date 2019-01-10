package com.kodilla.patterns.strategy.social;

public class Millenials extends User {
    public Millenials(String personName) {
        super(personName);
        this.socialPublisher = new FacebookPublisher();
    }
}
