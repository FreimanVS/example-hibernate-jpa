package com.vfreiman.lessons.hibernatejpaexamples.services;

import javax.persistence.EntityManager;

public class ControlSchemaService {
    private static final EntityManager em = EntityManagerService.getEm();

    public static void init() {
        drop();
        create();
    }

    public static void create() {
        final String SQL = FileService.readFromResource("META-INF/create.sql");

        em.getTransaction().begin();
        em.createNativeQuery(SQL).executeUpdate();
        em.getTransaction().commit();
    }

    public static void drop() {
        final String SQL = FileService.readFromResource("META-INF/drop.sql");

        em.getTransaction().begin();
        em.createNativeQuery(SQL).executeUpdate();
        em.getTransaction().commit();
    }
}
