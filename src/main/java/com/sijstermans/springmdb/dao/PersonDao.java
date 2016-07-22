package com.sijstermans.springmdb.dao;

import java.util.List;

import com.sijstermans.springmdb.models.Person;

public interface PersonDao {
	List<Person> findAll();

	Person findById(int id);
}
