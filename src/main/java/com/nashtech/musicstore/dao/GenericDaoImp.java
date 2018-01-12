package com.nashtech.musicstore.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

@SuppressWarnings("unchecked")
@Repository("genericDao")
@Transactional
public abstract class GenericDaoImp<E, K extends Serializable> implements IGenericDao<E, K> {

    @Autowired
    SessionFactory sessionFactory;

    protected Class<? extends E> daoType;

    public GenericDaoImp() {
        Type type = getClass().getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) type;
        daoType = (Class) parameterizedType.getActualTypeArguments()[0];
    }

    protected Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void add(E entity) {
        currentSession().save(entity);
    }

    public void saveOrUpdate(E entity) {
        currentSession().saveOrUpdate(entity);
    }

    public void update(E entity) {
        currentSession().saveOrUpdate(entity);
    }

    public void remove(E entity) {
        currentSession().delete(entity);
    }

    public E find(K key) {
        return currentSession()
                .get(daoType, key);
    }

    public List<E> getAll() {
        return currentSession()
                .createCriteria(daoType)
                .addOrder(Order.desc("modifiedAt"))
                .addOrder(Order.desc("createdAt"))
                .list();
    }
}
