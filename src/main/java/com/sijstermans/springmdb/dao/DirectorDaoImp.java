package com.sijstermans.springmdb.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.sijstermans.springmdb.models.Director;


@Repository
public class DirectorDaoImp extends AbstractDao implements DirectorDao {

	@Override
	@SuppressWarnings("unchecked")
	public List<Director> findAll() {
		Session s = getSession();
		ArrayList<Director> res = (ArrayList<Director>) s.createCriteria(Director.class).list();
		return res;
	}
}
