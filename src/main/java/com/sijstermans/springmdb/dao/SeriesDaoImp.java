package com.sijstermans.springmdb.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.sijstermans.springmdb.models.Series;

@Repository
public class SeriesDaoImp extends AbstractDao implements SeriesDao {

	@Override
	@SuppressWarnings("unchecked")
	public List<Series> findAll() {
		Session s = getSession();
		return (ArrayList<Series>) s.createCriteria(Series.class).list();
	}
	
	@Override
	public Series findById(int id) {
		Session s = getSession();
		return s.get(Series.class, id);
	}

	@Override
	public int addSeries(Series s) {
		Session session = getSession();
		session.save(s);
		return s.getScreenplayId();
	}

}
