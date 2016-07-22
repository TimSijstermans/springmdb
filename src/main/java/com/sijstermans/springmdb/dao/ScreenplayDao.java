package com.sijstermans.springmdb.dao;

import java.util.List;

import com.sijstermans.springmdb.models.Screenplay;

public interface ScreenplayDao {
	public List<Screenplay> findAll();
	
	public List<Screenplay> findByPerson(int id);
}