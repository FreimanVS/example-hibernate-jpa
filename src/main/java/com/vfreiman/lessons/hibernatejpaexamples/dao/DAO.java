package com.vfreiman.lessons.hibernatejpaexamples.dao;

import java.util.List;

public interface DAO<T> {
    long add(T obj);
    List<T> getList();
    T getById(long id);
    void deleteById(long id);
    void deleteAll();
    void updateById(long id, T obj);
}