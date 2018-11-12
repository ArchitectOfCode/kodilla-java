package com.kodilla.testing.colection;

import java.util.ArrayList;

public class OddNumbersExterminator {
    private ArrayList<Integer> numbersList;

    public void exterminate(ArrayList<Integer> numbers) {
        ArrayList<Integer> evenNumbersList = new ArrayList<Integer>();
        if(numbers == null) {
            numbersList = null;
        } else {
            for(Integer num : numbers) {
                if(num % 2 == 0) {
                    evenNumbersList.add(num);
                }
            }
            numbersList = evenNumbersList;
        }
    }

    public ArrayList<Integer> getNumbersList() {
        return numbersList;
    }

    public void setNumbersList(ArrayList<Integer> numbersList) {
        this.numbersList = numbersList;
    }
}
