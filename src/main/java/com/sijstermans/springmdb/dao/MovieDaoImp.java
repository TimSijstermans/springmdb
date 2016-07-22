package com.sijstermans.springmdb.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.sijstermans.springmdb.models.Movie;
import com.sijstermans.springmdb.models.Series;

@Repository
public class MovieDaoImp extends AbstractDao implements MovieDao {
	@Override
	@SuppressWarnings("unchecked")
	public List<Movie> findAll() {
		Session s = getSession();
		return (ArrayList<Movie>) s.createCriteria(Movie.class).list();
	}

	@Override
	public Movie findById(int id) {
		Session s = getSession();
		return s.get(Movie.class, id);
	}
}
