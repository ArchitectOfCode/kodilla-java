package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

public class BigmacTestSuite {
    @Test
    public void testBigmacNew() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .ingredient(Bigmac.CHEESE)
                .sauce("ketchup")
                .burgers(2)
                .bun("sesame")
                .ingredient(Bigmac.MUSHROOM)
                .ingredient(Bigmac.ONION)
                .ingredient(Bigmac.CHILLI_PEPPERS)
                .build();
        System.out.println(bigmac);

        //When
        int howManyIngredients = bigmac.getIngredients().size();

        //Then
        Assert.assertEquals(4, howManyIngredients);
        Assert.assertEquals("ketchup", bigmac.getSauce());
        Assert.assertEquals("sesame", bigmac.getBun());
        Assert.assertEquals(2, bigmac.getBurgers());
    }
}
