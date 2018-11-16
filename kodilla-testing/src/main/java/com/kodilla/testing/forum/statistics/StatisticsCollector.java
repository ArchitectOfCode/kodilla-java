package com.kodilla.testing.forum.statistics;

import java.util.ArrayList;

public class StatisticsCollector {
    private Statistics statistics;
    private ArrayList<String> usersNames = new ArrayList<String>();
    private int postsCount;
    private int commentsCount;
    private double avgNumberOfPostsPerUser;
    private double avgNumberOfCommentsPerUser;
    private double avgNumberOfCommentsPerPost;

    public StatisticsCollector(Statistics statistics) {
        this.statistics = statistics;
    }

    public boolean calculateAdvStatistics(Statistics statistics) {

/* TEST START
        usersNames.add("John Smith");
        usersNames.add("Stevie Wonder");
        usersNames.add("Ally McBeal");
/ TEST STOP */

        if(statistics.usersNames().size() > 0 && statistics.postsCount() > 0) {
            avgNumberOfPostsPerUser = (double)statistics.postsCount() / statistics.usersNames().size();
            avgNumberOfCommentsPerUser = (double)statistics.commentsCount() / statistics.usersNames().size();
            avgNumberOfCommentsPerPost = (double)statistics.commentsCount() / statistics.postsCount();
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<String> usersNames() {
        return usersNames;
    }

    public int postCount() {
        return postsCount;
    }

    public int commentsCount() {
        return commentsCount;
    }

    public double getAvgNumberOfPostsPerUser() {
        return avgNumberOfPostsPerUser;
    }

    public double getAvgNumberOfCommentsPerUser() {
        return avgNumberOfCommentsPerUser;
    }

    public double getAvgNumberOfCommentsPerPost() {
        return avgNumberOfCommentsPerPost;
    }

    public void showStatistics() {
        System.out.println("Total number of forum users: " + usersNames.size());
        System.out.println("Total number of posts: " + postsCount);
        System.out.println("Total number of comments: " + commentsCount);
        System.out.println("Average number of posts per user: " + avgNumberOfPostsPerUser);
        System.out.println("Average number of comments per user: " + avgNumberOfCommentsPerUser);
        System.out.println("Average number of comments per post: " + avgNumberOfCommentsPerPost);
    }
}
