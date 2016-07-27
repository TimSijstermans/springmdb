package com.sijstermans.springmdb.dao;

import org.springframework.stereotype.Repository;

import com.sijstermans.springmdb.models.Person;

@Repository
public class PersonDaoImp extends AbstractDao<Person, Integer> implements PersonDao{
}
