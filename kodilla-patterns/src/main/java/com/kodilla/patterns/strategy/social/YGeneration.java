package com.kodilla.patterns.strategy.social;

public class YGeneration extends User {
    public YGeneration(String personName) {
        super(personName);
        this.socialPublisher = new TwitterPublisher();
    }
}
