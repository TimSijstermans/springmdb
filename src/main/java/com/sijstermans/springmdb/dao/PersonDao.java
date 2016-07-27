package com.sijstermans.springmdb.dao;

import java.util.List;

import com.sijstermans.springmdb.models.Person;

public interface PersonDao {
	void add(Person entity);
    
    void saveOrUpdate(Person entity);
       
    void update(Person entity);
     
    void delete(Person entity);
       
    Person find(Integer key);
     
    List<Person> getAll();
}
