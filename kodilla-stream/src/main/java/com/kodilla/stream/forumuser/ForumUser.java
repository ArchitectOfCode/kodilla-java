package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {
    private final int forumUserID;
    private final String username;
    private final char gender;
    private final LocalDate dateOfBirth;
    private final int numberOfPosts;

    public ForumUser(int forumUserID, String username, char gender, int yearOfBirth, int monthOfBirth, int dayOfBirth, int numberOfPosts) {
        this.forumUserID = forumUserID;
        this.username = username;
        this.gender = gender;
        this.dateOfBirth = LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth);
        this.numberOfPosts = numberOfPosts;
    }

    public int getForumUserID() {
        return forumUserID;
    }

    public String getUsername() {
        return username;
    }

    public char getGender() {
        return gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getNumberOfPosts() {
        return numberOfPosts;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "forumUserID=" + forumUserID +
                ", username='" + username + '\'' +
                ", gender=" + gender +
                ", dateOfBirth=" + dateOfBirth +
                ", posts=" + numberOfPosts +
                '}';
    }
}
