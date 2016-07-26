package com.sijstermans.springmdb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sijstermans.springmdb.dao.DirectorDao;
import com.sijstermans.springmdb.dao.PersonDao;
import com.sijstermans.springmdb.models.Director;
import com.sijstermans.springmdb.models.Person;

@Transactional
@Service
public class PersonServiceImp implements PersonService{
	@Autowired
	PersonDao personDao;
	
	@Autowired
	DirectorDao directorDao;
	
	@Override
	public List<Person> findAll(){
		return (List<Person>) personDao.findAll();
	}
	
	@Override
	public Person findById(int id){
		return personDao.findById(id);
	}
	
	@Override
	public List<Director> findAllDirectors(){
		return (List<Director>) directorDao.findAll();
	}
	
	@Override
	public Director findDirectorById(int id) {
		Director d =  directorDao.findById(id);
		return d;
	}
}
