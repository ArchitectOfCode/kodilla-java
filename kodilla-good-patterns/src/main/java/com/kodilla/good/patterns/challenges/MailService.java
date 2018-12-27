package com.kodilla.good.patterns.challenges;

public class MailService implements InformationService {
    public boolean inform(User user) {
        System.out.println("User " + user.toString() + " has been notified about order.");
        return true;
    }
}
