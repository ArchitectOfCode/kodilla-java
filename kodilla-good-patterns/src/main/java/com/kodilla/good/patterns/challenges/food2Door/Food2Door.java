package com.kodilla.good.patterns.challenges.food2Door;

public class Food2Door {
    public static void main(String[] args) {
        Producer extraFoodShop = new ExtraFoodShop("ExtraFoodShop", "spirulina", 3.5);
        Producer healthyShop = new HealthyShop("HealthyShop", "Mung Beans", 20);
        Producer glutenFreeShop = new GlutenFreeShop("GlutenFreeShop", "Lentil flour", 30);

        System.out.println("Our vendors: ");
        extraFoodShop.showOffer();
        healthyShop.showOffer();
        glutenFreeShop.showOffer();

        System.out.println();
        extraFoodShop.process();
        System.out.println();

        extraFoodShop.showOffer();
        healthyShop.showOffer();
        glutenFreeShop.showOffer();
    }
}
