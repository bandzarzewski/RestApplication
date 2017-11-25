package com.newssystem.server.NewsSystem.service;

import java.util.List;

public interface ServiceInterface <T> {

    List<T> getObje();
    T add(T obj);
    T findById(Long id);
    T update(T obj);

}
