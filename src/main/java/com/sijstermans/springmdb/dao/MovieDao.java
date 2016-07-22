package com.sijstermans.springmdb.dao;

import java.util.List;

import com.sijstermans.springmdb.models.Movie;

public interface MovieDao {
	List<Movie> findAll();
	
	Movie findById(int id);
}
