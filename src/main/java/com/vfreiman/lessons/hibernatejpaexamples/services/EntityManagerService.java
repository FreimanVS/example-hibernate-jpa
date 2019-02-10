package com.vfreiman.lessons.hibernatejpaexamples.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerService {
    private static final String PERSISTENT_UNIT_NAME = "hibernatejpa";
    private static volatile EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENT_UNIT_NAME);

    private EntityManagerService() {}

    public static EntityManager getEm() {
        if (emf == null) {
            synchronized (EntityManagerService.class) {
                if (emf == null) {
                    emf = Persistence.createEntityManagerFactory(PERSISTENT_UNIT_NAME);
                }
            }
        }
        return emf.createEntityManager();
    }
}
