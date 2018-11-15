package com.kodilla.testing.shape;

public class Square implements Shape {
    int a;

    public Square(int a) {
        this.a = a;
    }

    public String getShapeName() {
        return "square";
    }
    public double getField() {
        return (a * a);
    }
}