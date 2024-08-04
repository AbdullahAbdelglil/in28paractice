package com.in28minutes.web.rest.weservices.restful_web_services.controller;

import com.in28minutes.web.rest.weservices.restful_web_services.dao.UserDAO;
import com.in28minutes.web.rest.weservices.restful_web_services.entity.User;
import com.in28minutes.web.rest.weservices.restful_web_services.exceptions.UserNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserDAO userDAO;

    public UserController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping("")
    public List<User> getAll() {
        return userDAO.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserByID(@PathVariable("id") int id) {
        User dbUser = userDAO.getUser(id);
        if (dbUser == null) {
            throw new UserNotFoundException("id: "+id);
        }

        return ResponseEntity.ok(dbUser);
    }

    @PostMapping("")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User savedUser = userDAO.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).body(savedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") int id) {
        User dbUser = userDAO.getUser(id);
        if (dbUser == null) {
            throw new UserNotFoundException("id: " + id);
        }

        userDAO.deleteUser(dbUser);
        return ResponseEntity.ok(dbUser);
    }
}
