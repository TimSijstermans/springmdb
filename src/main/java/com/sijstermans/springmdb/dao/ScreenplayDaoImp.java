package com.sijstermans.springmdb.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.sijstermans.springmdb.models.Screenplay;

@Repository
public class ScreenplayDaoImp extends AbstractDao implements ScreenplayDao {
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Screenplay> findAll(){
		Session s = getSession();
		return (ArrayList<Screenplay>) s.createCriteria(Screenplay.class).list();
	}

	@Override
	public List<Screenplay> findByPerson(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
