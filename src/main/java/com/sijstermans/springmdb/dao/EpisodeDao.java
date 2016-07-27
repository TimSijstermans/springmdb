package com.sijstermans.springmdb.dao;

import java.util.List;

import com.sijstermans.springmdb.models.Director;
import com.sijstermans.springmdb.models.Episode;

public interface EpisodeDao {
	void add(Episode entity);
    
    void saveOrUpdate(Episode entity);
       
    void update(Episode entity);
     
    void delete(Episode entity);
       
    Episode find(Integer key);
     
    List<Episode> getAll();
}
