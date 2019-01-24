package com.kodilla.hibernate.invoice;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "invoices")
public class Invoice {
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "invoice_id", unique = true)
    private int id;

    @Column(name = "number")
    private String number;

    @OneToMany(
            targetEntity = Item.class,
            mappedBy = "invoice_id",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Item> items;

    public Invoice() {
    }

    public Invoice(String number) {
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public List<Item> getItems() {
        return items;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setNumber(String number) {
        this.number = number;
    }

    private void setItems(List<Item> items) {
        this.items = items;
    }
}
