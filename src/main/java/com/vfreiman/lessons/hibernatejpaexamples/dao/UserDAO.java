package com.vfreiman.lessons.hibernatejpaexamples.dao;

import com.vfreiman.lessons.hibernatejpaexamples.entities.User;
import com.vfreiman.lessons.hibernatejpaexamples.services.EntityManagerService;

import javax.persistence.EntityManager;
import java.util.List;

public class UserDAO implements DAO<User> {
    private static final EntityManager em = EntityManagerService.getEm();

    @Override
    public long add(User obj) {
        em.getTransaction().begin();

        User newObj = em.merge(obj);
        em.flush();

        em.getTransaction().commit();
        return newObj.getId();
    }

    @Override
    public List<User> getList() {
        return em.createQuery("SELECT c FROM User c", User.class).getResultList();
    }

    @Override
    public User getById(long id) {
        return em.find(User.class, id);
    }

    @Override
    public void deleteById(long id) {
        em.getTransaction().begin();

        em.remove(getById(id));
        em.flush();

        em.getTransaction().commit();
    }

    public void deleteAll() {
        em.getTransaction().begin();

        getList().forEach(em::remove);
        em.flush();

        em.getTransaction().commit();
    }

    @Override
    public void updateById(long id, User obj) {
        em.getTransaction().begin();

        User objFromDB = getById(id);
        objFromDB.setName(obj.getName());
        objFromDB.setPassword(obj.getPassword());
        em.flush();

        em.getTransaction().commit();
    }
}
