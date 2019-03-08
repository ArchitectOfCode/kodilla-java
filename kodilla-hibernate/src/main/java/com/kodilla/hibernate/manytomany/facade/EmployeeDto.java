package com.kodilla.hibernate.manytomany.facade;

public final class EmployeeDto {
    private final int id;
    private final String firstName;
    private final String lastName;

    public EmployeeDto(final int id, final String firstName, final String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
