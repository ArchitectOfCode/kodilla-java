package com.kodilla.good.patterns.challenges.food2Door;

public class GlutenFreeShop implements Producer{
    private String name;
    private String product;
    private double quantity;

    public GlutenFreeShop(String name, String product, double quantity) {
        this.name = name;
        this.product = product;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public String getProduct() {
        return product;
    }

    public double getQuantity() {
        return quantity;
    }

    public boolean setQuantity(double quantity) {
        this.quantity = quantity;
        return true;
    }

    public boolean process() {
        System.out.println(getProduct() + " ordered from " + getName());
        setQuantity(0.0);
        return true;
    }

    public void showOffer() {
        System.out.println(getName() + " providing " + getProduct() + " [" + getQuantity() + " kg]");
    }
}
