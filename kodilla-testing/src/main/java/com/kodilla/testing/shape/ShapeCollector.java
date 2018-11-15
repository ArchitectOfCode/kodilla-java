package com.kodilla.testing.shape;

import java.util.ArrayList;

public class ShapeCollector {
    ArrayList<Shape> geometricFigures = new ArrayList<Shape>();

    public boolean addFigure(Shape shape) {
        if(shape == null) {
            return false;
        } else {
            geometricFigures.add(shape);
            return true;
        }
    }

    public boolean removeFigure(Shape shape) {
        if(shape == null || geometricFigures.contains(shape) == false || geometricFigures.isEmpty()) {
            return false;
        } else {
            geometricFigures.remove(shape);
            return true;
        }
    }

    public Shape getFigure(int position) {
        if(position >= 0 && position < geometricFigures.size()) {
            return geometricFigures.get(position);
        } else {
            return null;
        }

    }

    public void showFigures() {
        System.out.println("Figures in ArrayList:\n");
        for(int i = 0; i < geometricFigures.size(); i++) {
            System.out.println(i + ": " + geometricFigures.get(i).getShapeName() + " with field " + geometricFigures.get(i).getField());
        }
    }
}
