package com.in28minutes.web.rest.weservices.restful_web_services.entity;

import java.time.LocalDate;

public class User {

    private Integer id;
    private String username;
    private LocalDate birthDate;

    public User(Integer id, String username, LocalDate birthDate) {
        super();
        this.id = id;
        this.username = username;
        this.birthDate = birthDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User {" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
