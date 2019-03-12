package com.kodilla.patterns2.observer.homework;

public class KodillaMentor implements Mentor {
    private final String mentorName;
    private int exerciseCount;

    public KodillaMentor(String mentorName) {
        this.mentorName = mentorName;
    }

    @Override
    public void update(StudentExerciseList studentExerciseList) {
        System.out.println(mentorName + ": New exercises posted by student " + studentExerciseList.getName() +
                "\n (total: " + studentExerciseList.getExercises().size() + " exercisese)");
        exerciseCount++;
    }

    public String getName() {
        return mentorName;
    }

    public int getExerciseCount() {
        return exerciseCount;
    }
}
