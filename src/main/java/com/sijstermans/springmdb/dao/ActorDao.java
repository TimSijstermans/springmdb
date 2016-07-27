package com.sijstermans.springmdb.dao;

import java.util.List;

import com.sijstermans.springmdb.models.Actor;

public interface ActorDao {
	void add(Actor entity);
    
    void saveOrUpdate(Actor entity);
       
    void update(Actor entity);
     
    void delete(Actor entity);
       
    Actor find(Integer key);
     
    List<Actor> getAll();
}
