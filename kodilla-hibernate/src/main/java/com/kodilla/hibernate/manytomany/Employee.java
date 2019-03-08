package com.kodilla.hibernate.manytomany;

import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@NamedQuery(
        name = "Employee.retrieveEmployeesByLastName",
        query = "FROM Employee WHERE lastName = :LAST_NAME"
)

@NamedNativeQuery(
        name = "Employee.retrieveEmployeesByLastNameLike",
        query = "SELECT * FROM employees WHERE last_name LIKE CONCAT('%', :LAST_NAME, '%')"
)

@Entity
@Transactional
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "id", unique = true)
    private int id;

    @NotNull
    @Column(name = "firstName")
    private String firstName;

    @NotNull
    @Column(name = "lastName")
    private String lastName;

    /*@ManyToMany(cascade = CascadeType.ALL)*/
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "join_company_employee",
            joinColumns = {@JoinColumn(name = "employee_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "company_id", referencedColumnName = "id")}
    )
    private List<Company> companies = new ArrayList<>();

    public Employee() {
    }

    public Employee(String firstName, String lastName) {
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

    public List<Company> getCompanies() {
        return companies;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }
}
