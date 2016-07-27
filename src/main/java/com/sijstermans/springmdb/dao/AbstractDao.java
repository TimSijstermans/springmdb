package com.sijstermans.springmdb.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

@SuppressWarnings("unchecked")
public abstract class AbstractDao<E, K extends Serializable>  {
	@Autowired
	SessionFactory sf;
	
	//extends entity
	protected Class<? extends E> daoClass;
	
	
	public AbstractDao(){
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        daoClass = (Class) pt.getActualTypeArguments()[0];
	}

	protected Session getSession(){
		return sf.getCurrentSession();
	}
	
    public void add(E entity) {
    	getSession().save(entity);
    }
     
    public void saveOrUpdate(E entity) {
        getSession().saveOrUpdate(entity);
    }
       
    public void update(E entity) {
        getSession().saveOrUpdate(entity);
    }
     
    public void delete(E entity) {
        getSession().delete(entity);
    }
       
    public E find(K key) {
        return (E) getSession().get(daoClass, key);
    }
     
    public List<E> getAll() {
        return getSession().createCriteria(daoClass).list();
    }
	
}
