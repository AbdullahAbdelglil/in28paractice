package com.in28minutes.web.rest.weservices.restful_web_services.dao;

import com.in28minutes.web.rest.weservices.restful_web_services.entity.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class UserDAO {

    private static List<User> users = new ArrayList<>();
    private static int userId = 0;
    static {
        users.add(new User(++userId, "Abdullah", LocalDate.now().minusYears(22)));
        users.add(new User(++userId, "Ahmed", LocalDate.now().minusYears(30)));
        users.add(new User(++userId, "ALi", LocalDate.now().minusYears(40)));
    }

    public User save(User user) {
        user.setId(++userId);
        users.add(user);
        return user;
    }

    public List<User> getAll() {
        return users;
    }

    public User getUser(int id) {
        return users.stream()
                .filter(user -> user.getId()==id)
                .findFirst()
                .orElse(null);
    }

    public void deleteUser(User user) {
        users.removeIf(u -> u.getId().equals(user.getId()));
    }

}
