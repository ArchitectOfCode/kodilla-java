package com.kodilla.hibernate.manytomany.facade;

import java.util.ArrayList;
import java.util.List;

public final class CompanyDto {
    private final int id;
    private final String name;
    private final List<EmployeeDto> employees = new ArrayList<>();

    public CompanyDto(final int id, final String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addEmployee(final EmployeeDto employeeDto) {
        employees.add(employeeDto);
    }

    public List<EmployeeDto> getEmployees() {
        return employees;
    }
}
