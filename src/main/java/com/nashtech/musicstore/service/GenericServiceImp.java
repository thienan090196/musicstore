package com.nashtech.musicstore.service;

import com.nashtech.musicstore.dao.IGenericDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class GenericServiceImp<E, K> implements IGenericService<E, K> {

    @Autowired
    private IGenericDao<E, K> genericDao;

    public GenericServiceImp(IGenericDao<E,K> genericDao) {
        this.genericDao = genericDao;
    }

    public GenericServiceImp() {
    }

    public void add(E entity) {
        genericDao.add(entity);
    }

    public void saveOrUpdate(E entity) {
        genericDao.saveOrUpdate(entity);
    }

    public void update(E entity) {
        genericDao.update(entity);
    }

    public void remove(E entity) {
        genericDao.remove(entity);
    }

    public E find(K key) {
        return genericDao.find(key);
    }

    public List<E> getAll() {
        return genericDao.getAll();
    }
}
