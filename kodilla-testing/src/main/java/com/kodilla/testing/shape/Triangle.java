package com.kodilla.testing.shape;

public class Triangle implements Shape {
    int a;
    int h;

    public Triangle(int a, int h) {
        this.a = a;
        this.h = h;
    }

    public String getShapeName() {
        return "triangle";
    }
    public double getField() {
        return (a * h) / 2;
    }
}
