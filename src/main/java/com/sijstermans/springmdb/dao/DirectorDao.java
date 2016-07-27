package com.sijstermans.springmdb.dao;

import java.util.List;

import com.sijstermans.springmdb.models.Director;

public interface DirectorDao {
		
	void add(Director entity);
     
    void saveOrUpdate(Director entity);
       
    void update(Director entity);
     
    void delete(Director entity);
       
    Director find(Integer key);
     
    List<Director> getAll();
}
