package com.vfreiman.lessons.hibernatejpaexamples.builders;

import com.vfreiman.lessons.hibernatejpaexamples.entities.User;

public class UserBuilder {
    private int id;
    private String name;
    private String password;

    public UserBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public User build() {
        User user = new User();
        user.setName(this.name);
        user.setPassword(this.password);
        return user;
    }
}
