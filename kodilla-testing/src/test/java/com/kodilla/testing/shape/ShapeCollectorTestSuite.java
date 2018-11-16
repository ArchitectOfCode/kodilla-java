package com.kodilla.testing.shape;

import org.junit.*;

public class ShapeCollectorTestSuite {
    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Test
    public void testGetShapeNameTriangle() {
        // Given / Arrange
        Shape triangle = new Triangle(4, 3);
        String shapeNameTriangle = "triangle";

        // When / Act
        String shapeName = triangle.getShapeName();

        // Then / Assert
        Assert.assertEquals(shapeNameTriangle, shapeName);
    }

    @Test
    public void testGetShapeNameCircle() {
        // Given / Arrange
        Shape circle= new Circle(3);
        String shapeNameCircle = "circle";

        // When / Act
        String shapeName = circle.getShapeName();

        // Then / Assert
        Assert.assertEquals(shapeNameCircle, shapeName);
    }

    @Test
    public void testGetShapeNameSquare() {
        // Given / Arrange
        Shape square = new Square(3);
        String shapeNameSquare = "square";

        // When / Act
        String shapeName = square.getShapeName();

        // Then / Assert
        Assert.assertEquals(shapeNameSquare, shapeName);
    }

    @Test
    public void testGetFieldTriangle() {
        // Given / Arrange
        Shape triangle = new Triangle(4, 3);
        double field = 6.0;

        // When / Act
        double shapeField = triangle.getField();

        // Then / Assert
        Assert.assertEquals(field, shapeField, 0.001);
    }

    @Test
    public void testGetFieldCircle() {
        // Given / Arrange
        Shape circle= new Circle(3);
        double field = 28.274;

        // When / Act
        double shapeField = circle.getField();

        // Then / Assert
        Assert.assertEquals(field, shapeField, 0.001);
    }

    @Test
    public void testGetFieldSquare() {
        // Given / Arrange
        Shape square = new Square(3);
        double field = 9.0;

        // When / Act
        double shapeField = square.getField();

        // Then / Assert
        Assert.assertEquals(field, shapeField, 0.001);
    }

    @Test
    public void testAddTriangle() {
        // Given / Arrange
        ShapeCollector sColl = new ShapeCollector();
        Shape figure = new Triangle(4, 3);

        // When / Act
        boolean added = sColl.addFigure(figure);

        // Then / Assert
        Assert.assertTrue(added);
    }

    @Test
    public void testAddCircle() {
        // Given / Arrange
        ShapeCollector sColl = new ShapeCollector();
        Shape figure= new Circle(3);

        // When / Act
        boolean added = sColl.addFigure(figure);

        // Then / Assert
        Assert.assertTrue(added);
    }

    @Test
    public void testAddSquare() {
        // Given / Arrange
        ShapeCollector sColl = new ShapeCollector();
        Shape figure = new Square(3);

        // When / Act
        boolean added = sColl.addFigure(figure);

        // Then / Assert
        Assert.assertTrue(added);
    }

    @Test
    public void testAddNoFigure() {
        // Given / Arrange
        ShapeCollector sColl = new ShapeCollector();
        Triangle figure = null;

        // When / Act
        boolean added = sColl.addFigure(figure);

        // Then / Assert
        Assert.assertFalse(added);
    }

    @Test
    public void testRemoveTriangle() {
        // Given / Arrange
        ShapeCollector sColl = new ShapeCollector();
        Shape figure = new Triangle(4, 3);
        sColl.addFigure(figure);

        // When / Act
        boolean removed = sColl.removeFigure(figure);

        // Then / Assert
        Assert.assertTrue(removed);
    }

    @Test
    public void testRemoveCircle() {
        // Given / Arrange
        ShapeCollector sColl = new ShapeCollector();
        Shape figure= new Circle(3);
        sColl.addFigure(figure);

        // When / Act
        boolean removed = sColl.removeFigure(figure);

        // Then / Assert
        Assert.assertTrue(removed);
    }

    @Test
    public void testRemoveSquare() {
        // Given / Arrange
        ShapeCollector sColl = new ShapeCollector();
        Shape figure = new Square(3);
        sColl.addFigure(figure);

        // When / Act
        boolean removed = sColl.removeFigure(figure);

        // Then / Assert
        Assert.assertTrue(removed);
    }

    @Test
    public void testRemoveNoFigure() {
        // Given / Arrange
        ShapeCollector sColl = new ShapeCollector();
        Triangle figure = null;
        sColl.addFigure(figure);

        // When / Act
        boolean removed = sColl.removeFigure(figure);

        // Then / Assert
        Assert.assertFalse(removed);
    }

    @Test
    public void testGetFigure() {
        // Given / Arrange
        ShapeCollector sColl = new ShapeCollector();
        Shape triangle = new Triangle(4, 3);
        sColl.addFigure(triangle);

        // When / Act
        Shape figure = sColl.getFigure(0);

        // Then / Assert
        Assert.assertEquals(triangle, figure);
    }

    @Test
    public void testGetNoFigure() {
        // Given / Arrange
        ShapeCollector sColl = new ShapeCollector();
        Shape triangle = new Triangle(4, 3);
        sColl.addFigure(triangle);

        // When / Act
        Shape figure = sColl.getFigure(5);

        // Then / Assert
        Assert.assertNull(figure);
    }
}
