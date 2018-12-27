package com.kodilla.good.patterns.challenges.food2Door;

import com.kodilla.good.patterns.challenges.food2Door.FoodProducer;

public class Food2Door {
    public static void main(String[] args) {
        FoodProducer extraFoodShop = new FoodProducer("ExtraFoodShop", "spirulina", 3.5);
        FoodProducer healthyShop = new FoodProducer("HealthyShop", "Mung Beans", 20);
        FoodProducer glutenFreeShop = new FoodProducer("GlutenFreeShop", "Lentil flour", 30);

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
