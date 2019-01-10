package com.kodilla.patterns.strategy.social;

public class User {
    final private String personName;
    protected SocialPublisher socialPublisher;

    public User(String personName) {
        this.personName = personName;
    }

    public String getPersonName() {
        return personName;
    }

    public String sharePost() {
        return socialPublisher.share();
    }

    public void setSocialPublisher(SocialPublisher socialPublisher) {
        this.socialPublisher = socialPublisher;
    }
}
