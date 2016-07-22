package com.sijstermans.springmdb.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.sijstermans.springmdb.models.Person;
import com.sijstermans.springmdb.models.Series;

@Repository
public class PersonDaoImp extends AbstractDao implements PersonDao{

	@Override
	@SuppressWarnings("unchecked")
	public List<Person> findAll() {
		Session s = getSession();
		return s.createCriteria(Person.class).list();
	}
	
	@Override
	public Person findById(int id) {
		Session s = getSession();
		return s.get(Person.class, id);
	}

}
