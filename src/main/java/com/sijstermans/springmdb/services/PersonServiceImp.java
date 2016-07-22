package com.sijstermans.springmdb.services;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sijstermans.springmdb.dao.DirectorDao;
import com.sijstermans.springmdb.dao.PersonDao;
import com.sijstermans.springmdb.models.Person;

@Transactional
@Service
public class PersonServiceImp implements PersonService{
	@Autowired
	PersonDao personDao;
	
	@Override
	public List<Person> findAll(){
		return (List<Person>) personDao.findAll();
	}
	
	@Override
	public Person findById(int id){
		return personDao.findById(id);
	}
}
