package com.kodilla.stream.forumuser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class Forum {
    private final List<ForumUser> forumUsers = new ArrayList<>();

    public Forum() {
        forumUsers.add(new ForumUser(0001, "Cat Tip Top", 'M', 1970, 07, 03, 6));
        forumUsers.add(new ForumUser(0002, "George Jetson", 'M', 1982, 03, 02, 16));
        forumUsers.add(new ForumUser(0003, "Jane Jetson", 'F', 1986, 12, 21, 3));
        forumUsers.add(new ForumUser(0004, "Judie Jetson", 'F', 2006, 01, 03, 367));
        forumUsers.add(new ForumUser(0005, "Elroy Jetson", 'M', 2011, 03, 14, 12));
        forumUsers.add(new ForumUser(0006, "Yogi Bear", 'M', 1958, 04, 20, 0));
    }

    public final List<ForumUser> getUserList() {
        return new ArrayList<>(forumUsers);
    }
/*
    public ArrayList<ForumUser> showMans() {
        List<ForumUser> listOfMans = new ArrayList<>(forumUsers);
        listOfMans = forumUsers.stream()
                .filter(s -> s.gender == 'M')
                .collect(Collectors.toList());
        return listOfMans;
    }

    public void showWomans() {

    }
*/
}
