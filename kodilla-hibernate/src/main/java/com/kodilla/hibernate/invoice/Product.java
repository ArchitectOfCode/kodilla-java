package com.kodilla.hibernate.invoice;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "product_id", unique = true)
    private int id;

    @NotNull
    @Column(name = "product_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    public Product() {
    }

    public Product(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setName(String name) {
        this.name = name;
    }
}
