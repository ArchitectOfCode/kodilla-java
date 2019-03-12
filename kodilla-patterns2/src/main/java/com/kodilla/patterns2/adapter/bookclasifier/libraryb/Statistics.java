package com.kodilla.patterns2.adapter.bookclasifier.libraryb;

import java.util.Arrays;
import java.util.Map;

public class Statistics implements BookStatistics {
    @Override
    public int averagePublicationYear(Map<BookSignature, Book> books) {
        if(books.size() == 0) return 0;
        int sum = 0;
        for(Map.Entry<BookSignature, Book> entry : books.entrySet()) {
            sum += entry.getValue().getYearOfPublication();
        }
        return sum / books.size();
    }

    @Override
    public int medianPublicationYear(Map<BookSignature, Book> books) {
        if(books.size() == 0) return 0;
        int[] years = new int[books.size()];
        int n = 0;
        for(Map.Entry<BookSignature, Book> entry : books.entrySet()) {
            years[n] = entry.getValue().getYearOfPublication();
            n++;
        }
        Arrays.sort(years);
        if(years.length % 2 == 0) {
            return (int)(years[(int)(years.length / 2) - 1] + years[years.length / 2]) / 2;
            /* Logic explanation for 6 element array
            1 2 3 4 5 6 - position
            0 1 2 3 4 5 - in zero indexing

            (years[(6/2)-1] + years[(6/2)) / 2
            (years[3-1] + years[3]) / 2
            (years[2] + years[3]) / 2
            */

            //Kodilla's "simplified" example :P
            //return years[(int)(years.length / 2 + 0.5)];
        } else {
            return years[(years.length / 2) - 1];   // -1 because of zero indexing
        }
    }
}
