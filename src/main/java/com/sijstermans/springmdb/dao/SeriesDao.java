package com.sijstermans.springmdb.dao;

import java.util.List;

import com.sijstermans.springmdb.models.Series;

public interface SeriesDao {
	void add(Series entity);
    
    void saveOrUpdate(Series entity);
       
    void update(Series entity);
     
    void delete(Series entity);
       
    Series find(Integer key);
     
    List<Series> getAll();
}
