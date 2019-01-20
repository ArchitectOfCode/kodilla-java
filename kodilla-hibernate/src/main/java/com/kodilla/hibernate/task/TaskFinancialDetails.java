package com.kodilla.hibernate.task;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "tasks_financial")
public class TaskFinancialDetails {
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "id", unique = true)
    private int id;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "paid")
    private boolean paid;

    public TaskFinancialDetails() {
    }

    public TaskFinancialDetails(BigDecimal price, boolean paid) {
        this.price = price;
        this.paid = paid;
    }

    public int getId() {
        return id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public boolean isPaid() {
        return paid;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setPrice(BigDecimal price) {
        this.price = price;
    }

    private void setPaid(boolean paid) {
        this.paid = paid;
    }
}
