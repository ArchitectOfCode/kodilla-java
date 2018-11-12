package com.kodilla.testing.collection;

import com.kodilla.testing.colection.OddNumbersExterminator;
import org.junit.*;

import java.util.ArrayList;

public class CollectionTestSuite {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Collection Test Suite: begin");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("Collection Test Suite: end");
    }

    @Before
    public void before() {
        System.out.println("Test Case begin");
    }

    @After
    public void after() {
        System.out.println("Test Case end\n");
    }

    @Test
    public void testOddNumbersExterminatorEmptyList() {
        ArrayList<Integer> emptyList = null;
        OddNumbersExterminator numbersList = new OddNumbersExterminator();
        numbersList.exterminate(emptyList);
        System.out.println("testList = " + numbersList.getNumbersList());
        if(emptyList == null) {
            System.out.println("The list is empty.");
        } else {
            System.out.println("emptyList = " + emptyList.toString());
        }

        Assert.assertEquals(null, numbersList.getNumbersList());
    }

    @Test
    public void testOddNumbersExterminatorNormalList() {
        ArrayList<Integer> testList = new ArrayList<Integer>();
        OddNumbersExterminator numbersList = new OddNumbersExterminator();
        Integer[] tstList = {3, 5, 6, 3, 4, 6, 7, 9, 1, 5, 8, 2, 2, 4, 8, 6, 4};
        for(int i = 0; i < tstList.length; i++) {
            testList.add(tstList[i]);
        }
        ArrayList<Integer> expectedList = new ArrayList<Integer>();
        Integer[] expList = {6, 4, 6, 8, 2, 2, 4, 8, 6, 4};
        for(int i = 0; i < expList.length; i++) {
            expectedList.add(expList[i]);
        }

        numbersList.setNumbersList(testList);
        System.out.println("testList = " + numbersList.getNumbersList().toString());
        System.out.println("expectedList = " + expectedList.toString());

        numbersList.exterminate(testList);
        System.out.println("received list = " + numbersList.getNumbersList().toString());

        Assert.assertEquals(expectedList, numbersList.getNumbersList());
    }
}
