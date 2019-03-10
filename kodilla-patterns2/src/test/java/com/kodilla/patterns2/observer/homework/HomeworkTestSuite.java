package com.kodilla.patterns2.observer.homework;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HomeworkTestSuite {
    @Test
    public void testExercises() {
        //Given
        StudentExerciseList johnsExercises = new StudentExerciseList("John's exercises");
        StudentExerciseList janesExercises = new StudentExerciseList("Jane's Exercises");
        StudentExerciseList kateExercises = new StudentExerciseList("Kate's Exercises");
        KodillaMentor mentorAndrzej = new KodillaMentor("Andrzej Jaromin");
        KodillaMentor mentorMichal = new KodillaMentor("Michał Orłowski");
        johnsExercises.registerMentor(mentorAndrzej);
        janesExercises.registerMentor(mentorMichal);
        kateExercises.registerMentor(mentorAndrzej);
        kateExercises.registerMentor(mentorMichal);

        //When
        johnsExercises.addExercise("Use Strings in Java");
        johnsExercises.addExercise("Use while loop");
        janesExercises.addExercise("Apply Observer template");
        kateExercises.addExercise("Use stream to list tasks");
        kateExercises.addExercise("Write method to compute factorial");
        kateExercises.addExercise("Use recurency in stream");

        //Then
        assertEquals(5, mentorAndrzej.getExerciseCount());
        assertEquals(4, mentorMichal.getExerciseCount());
        assertEquals(2, johnsExercises.getExercises().size());
        assertEquals(1, janesExercises.getExercises().size());
        assertEquals(3, kateExercises.getExercises().size());
    }
}
