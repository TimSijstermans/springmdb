package com.sijstermans.springmdb.dao;

import java.util.List;

import com.sijstermans.springmdb.models.Episode;
import com.sijstermans.springmdb.models.Movie;

public interface MovieDao {
	void add(Movie entity);
    
    void saveOrUpdate(Movie entity);
       
    void update(Movie entity);
     
    void delete(Movie entity);
       
    Movie find(Integer key);
     
    List<Movie> getAll();
}
