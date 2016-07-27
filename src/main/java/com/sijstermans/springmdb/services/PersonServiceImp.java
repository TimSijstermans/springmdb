package com.sijstermans.springmdb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sijstermans.springmdb.dao.ActorDao;
import com.sijstermans.springmdb.dao.DirectorDao;
import com.sijstermans.springmdb.dao.PersonDao;
import com.sijstermans.springmdb.models.Actor;
import com.sijstermans.springmdb.models.Director;
import com.sijstermans.springmdb.models.Person;

@Transactional
@Service
public class PersonServiceImp implements PersonService{
	@Autowired
	PersonDao personDao;
	
	@Autowired
	DirectorDao directorDao;
	
	@Autowired
	ActorDao actorDao;
	
	@Override
	public List<Person> findAll(){
		return personDao.getAll();
	}
	
	@Override
	public Person findById(int id){
		return personDao.find(id);
	}
	
	@Override
	public List<Director> findAllDirectors(){
		return directorDao.getAll();
	}
	
	@Override
	public Director findDirectorById(int id) {
		return directorDao.find(id);
	}
	
	@Override
	public List<Actor> findAllActors(){
		return actorDao.getAll();
	}
	
	@Override
	public Actor findActorById(int id) {
		return actorDao.find(id);
	}
}
