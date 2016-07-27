package com.sijstermans.springmdb.dao;

import java.util.List;

import com.sijstermans.springmdb.models.Person;
import com.sijstermans.springmdb.models.Screenplay;

public interface ScreenplayDao {
	
	public List<Screenplay> findByPersonId(int personId);

	void add(Screenplay entity);
    
    void saveOrUpdate(Screenplay entity);
       
    void update(Screenplay entity);
     
    void delete(Screenplay entity);
       
    Screenplay find(Integer key);
     
    List<Screenplay> getAll();
}
