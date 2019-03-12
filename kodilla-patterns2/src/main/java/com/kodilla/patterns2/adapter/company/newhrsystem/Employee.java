package com.kodilla.patterns2.adapter.company.newhrsystem;

import java.math.BigDecimal;

public class Employee {
    final private String pesel;
    final private String firstName;
    final private String lastName;
    final private BigDecimal baseSalary;

    public Employee(String pesel, String firstName, String lastName, BigDecimal baseSalary) {
        this.pesel = pesel;
        this.firstName = firstName;
        this.lastName = lastName;
        this.baseSalary = baseSalary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public BigDecimal getBaseSalary() {
        return baseSalary;
    }

    public String getPesel() {
        return pesel;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof Employee)) return false;

        Employee employee = (Employee) o;

        return pesel != null ? pesel.equals(employee.pesel) : employee.pesel == null;
    }

    @Override
    public int hashCode() {
        return pesel != null ? pesel.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Employee{PESEL = '" + pesel + "', firstName = '" + firstName +
                "', lastName = '" + lastName + "', baseSalary = " + baseSalary + "}";
    }
}
