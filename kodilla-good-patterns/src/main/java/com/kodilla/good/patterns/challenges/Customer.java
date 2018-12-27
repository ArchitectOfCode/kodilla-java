package com.kodilla.good.patterns.challenges;

public class Customer implements User {
    private int customerID;
    private String lastName;
    private String firstName;

    public Customer(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}
