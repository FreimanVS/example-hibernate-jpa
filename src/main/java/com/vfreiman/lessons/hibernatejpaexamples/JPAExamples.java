package com.vfreiman.lessons.hibernatejpaexamples;

import com.vfreiman.lessons.hibernatejpaexamples.builders.UserBuilder;
import com.vfreiman.lessons.hibernatejpaexamples.dao.UserDAO;
import com.vfreiman.lessons.hibernatejpaexamples.entities.User;
import com.vfreiman.lessons.hibernatejpaexamples.services.ControlSchemaService;

public class JPAExamples {
    public static void main(String[] args) {
        ControlSchemaService.init();

        final UserDAO userDAO = new UserDAO();

        userDAO.add(new UserBuilder().setName("name1").setPassword("password1").build());
        userDAO.add(new UserBuilder().setName("name2").setPassword("password2").build());

        System.out.print("USER BY ID 1: ");
        User userById = userDAO.getById(1L);
        System.out.println(userById);
        System.out.println("==========================");

        System.out.println("GET ALL USERS: ");
        userDAO.getList().forEach(System.out::println);
        System.out.println("==========================");

        System.out.print("UPDATE USER BY ID 1: ");
        userDAO.updateById(1L, new UserBuilder().setName("updatedName").setPassword("updatedPassword").build());
        System.out.println(userDAO.getById(1L));
        System.out.println("==========================");

        System.out.println("DELETE USER BY ID 1");
        userDAO.deleteById(1L);
        System.out.println("ALL USERS: ");
        userDAO.getList().forEach(System.out::println);

        userDAO.deleteAll();
    }
}
