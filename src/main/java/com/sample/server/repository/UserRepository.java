package com.sample.server.repository;

import com.sample.server.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * In memory 'database'
 */
@Repository
public class UserRepository {

    private final static List<User> database = new ArrayList<>();

    static {
        database.add(new User("admin", "admin", "ADMIN"));
        database.add(new User("user", "user", "USER"));
    }

    public Optional<User> getByName(String name) {
        return database.stream().filter(e -> e.getName().equals(name)).findFirst();
    }
}