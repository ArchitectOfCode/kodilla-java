package com.kodilla.patterns2.decorator.pizza;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class PizzaOrderTestSuite {
    @Test
    public void testBasicPizzaOrderGetCost() {
        // Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        // When
        BigDecimal calculatedCost = pizzaOrder.getCost();
        // Then
        assertEquals(new BigDecimal(15.00), calculatedCost);
    }

    @Test
    public void testBasicPizzaOrderGetDescription() {
        // Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        // When
        String description = pizzaOrder.getDescription();
        // Then
        assertEquals("Pizza (dough, cheese, tomato sauce)", description);
    }

    @Test
    public void testPizzaOrderWithExtraCheeseGetCost() {
        // Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new ExtraCheeseDecorator(pizzaOrder);
        // When
        BigDecimal calculatedCost = pizzaOrder.getCost();
        // Then
        assertEquals(new BigDecimal(23.00), calculatedCost);
    }

    @Test
    public void testPizzaOrderWithExtraCheeseGetDescription() {
        // Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new ExtraCheeseDecorator(pizzaOrder);
        // When
        String description = pizzaOrder.getDescription();
        // Then
        assertEquals("Pizza (dough, cheese, tomato sauce) + extra cheese", description);
    }

    @Test
    public void testPizzaOrderWithExtraCheeseAndGarlicAndJalapenoGetCost() {
        // Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new ExtraCheeseDecorator(pizzaOrder);
        pizzaOrder = new GarlicDecorator(pizzaOrder);
        pizzaOrder = new JalapenoDecorator(pizzaOrder);
        // When
        BigDecimal calculatedCost = pizzaOrder.getCost();
        // Then
        assertEquals(new BigDecimal(33.00), calculatedCost);
    }

    @Test
    public void testPizzaOrderWithExtraCheeseAndGarlicAndJalapenoGetDescription() {
        // Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new ExtraCheeseDecorator(pizzaOrder);
        pizzaOrder = new GarlicDecorator(pizzaOrder);
        pizzaOrder = new JalapenoDecorator(pizzaOrder);
        // When
        String description = pizzaOrder.getDescription();
        // Then
        assertEquals("Pizza (dough, cheese, tomato sauce) + extra cheese + garlic + jalapeno peppers", description);
    }

    @Test
    public void testPizzaOrderWithOlivesAndGarlicAndJalapenoAndMushroomsGetCost() {
        // Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new OlivesDecorator(pizzaOrder);
        pizzaOrder = new GarlicDecorator(pizzaOrder);
        pizzaOrder = new JalapenoDecorator(pizzaOrder);
        pizzaOrder = new MushroomDecorator(pizzaOrder);
        // When
        BigDecimal calculatedCost = pizzaOrder.getCost();
        // Then
        assertEquals(new BigDecimal(33.00), calculatedCost);
    }

    @Test
    public void testPizzaOrderWithOlivesAndGarlicAndJalapenoAndMushroomsGetDescription() {
        // Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new OlivesDecorator(pizzaOrder);
        pizzaOrder = new GarlicDecorator(pizzaOrder);
        pizzaOrder = new JalapenoDecorator(pizzaOrder);
        pizzaOrder = new MushroomDecorator(pizzaOrder);
        // When
        String description = pizzaOrder.getDescription();
        // Then
        assertEquals("Pizza (dough, cheese, tomato sauce) + olives + garlic + jalapeno peppers + mushrooms", description);
    }
}
