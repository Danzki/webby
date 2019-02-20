package com.example.webby;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private List<String> friends;

    /*  Constructor with parameter  */
    public User(String name, List<String> friends){
        this.name = name;
        List<String> realFriends = new ArrayList();
        realFriends.addAll(friends);
        this.friends = realFriends;
    }

    public String getName() {
        return name;
    }

    public List<String> getFriends() {
        return friends;
    }
}
