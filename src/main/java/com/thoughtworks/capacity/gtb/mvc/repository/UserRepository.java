package com.thoughtworks.capacity.gtb.mvc.repository;

import com.thoughtworks.capacity.gtb.mvc.domain.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository{
    private final Map<String, User> users = new HashMap<>();

    public int count() {return users.size();}

    public User register(User user) {
        users.put(user.getUsername(), user);
        return user;
    }

    public boolean isExisted(User user) {
        return users.containsKey(user.getUsername());
    }

    public User findByUsername(String username) {
        return users.get(username);
    }
}
