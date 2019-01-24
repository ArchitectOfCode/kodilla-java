package com.kodilla.hibernate.invoice;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "item_id", unique = true)
    private int id;

    /*
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    */

    @ManyToOne(
            targetEntity = Product.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private Product product;


    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "quantity")
    private int quantity;

    @Transient
    private BigDecimal value;

    @ManyToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;

    public Item() {
    }

    public Item(Product product, BigDecimal price, int quantity) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        value = price.multiply(new BigDecimal(quantity));
    }

    public int getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    private void setId(int id) {
        this.id = id;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    private void setPrice(BigDecimal price) {
        this.price = price;
        this.calculateValue();
    }

    private void setQuantity(int quantity) {
        this.quantity = quantity;
        this.calculateValue();
    }

    private void calculateValue() {
        value = price.multiply(new BigDecimal(quantity));
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}
