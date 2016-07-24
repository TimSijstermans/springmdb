package com.sijstermans.springmdb.dao;

import java.util.List;

import com.sijstermans.springmdb.models.Director;

public interface DirectorDao {
	List<Director> findAll();
	
	Director findById(int id);
}
