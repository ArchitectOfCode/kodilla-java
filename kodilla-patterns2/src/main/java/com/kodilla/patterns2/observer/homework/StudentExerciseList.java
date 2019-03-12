package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;

public class StudentExerciseList implements Exercises{
    private final List<Mentor> mentors;
    private final List<String> exercises;
    private final String exerciseListName;

    public StudentExerciseList(String exerciseListName) {
        mentors = new ArrayList<>();
        exercises = new ArrayList<>();
        this.exerciseListName = exerciseListName;
    }

    public void addExercise(String exercise) {
        exercises.add(exercise);
        notifyMentors();
    }

    @Override
    public void registerMentor(Mentor mentor) {
        mentors.add(mentor);
    }

    @Override
    public void notifyMentors() {
        for(Mentor mentor : mentors) {
            mentor.update(this);
        }
    }

    @Override
    public void removeMentor(Mentor mentor) {
        mentors.remove(mentor);
    }

    public List<String> getExercises() {
        return exercises;
    }

    public String getName() {
        return exerciseListName;
    }
}
