package com.sijstermans.springmdb.services;

import java.util.List;

import com.sijstermans.springmdb.models.Person;

public interface PersonService {
	public List<Person> findAll();

	Person findById(int id);
}