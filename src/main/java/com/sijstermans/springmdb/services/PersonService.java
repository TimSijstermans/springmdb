package com.sijstermans.springmdb.services;

import java.util.List;

import com.sijstermans.springmdb.models.Director;
import com.sijstermans.springmdb.models.Person;
import com.sijstermans.springmdb.models.Screenplay;

public interface PersonService {
	public List<Person> findAll();

	Person findById(int id);
	
	List<Director> findAllDirectors();
	
	Director findDirectorById(int id);

}
