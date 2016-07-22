package com.sijstermans.springmdb.services;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sijstermans.springmdb.dao.MovieDao;
import com.sijstermans.springmdb.dao.ScreenplayDao;
import com.sijstermans.springmdb.dao.SeriesDao;
import com.sijstermans.springmdb.models.Movie;
import com.sijstermans.springmdb.models.Screenplay;
import com.sijstermans.springmdb.models.Series;

@Transactional
@Service
public class ScreenplayServiceImp implements ScreenplayService {

	@Autowired
	SeriesDao seriesDao;
	
	@Autowired
	MovieDao movieDao;
	
	@Autowired
	ScreenplayDao screenplayDao;
	
	public List<Series> findAllSeries() {
		List<Series> s = seriesDao.findAll();
		for (Series entry : s) {
			Hibernate.initialize(entry.getEpisodes());
			Hibernate.initialize(entry.getActors());
		}
		return s;
	}

	@Override
	public List<Movie> findAllMovies() {
		List<Movie> m = movieDao.findAll();
		for (Movie entry : m) {
			Hibernate.initialize(entry.getActors());
		}
		return m;
	}

	@Override
	public List<Screenplay> findAll() {
		List<Screenplay> sp = screenplayDao.findAll();
		for (Screenplay entry : sp) {
			Hibernate.initialize(entry.getActors());
			if (entry.getClass().equals(Series.class)){
				Hibernate.initialize(((Series) entry).getEpisodes());
			}
		}
		return sp;
	}

	@Override
	public Series findSeriesById(int id) {
		Series s =  seriesDao.findById(id);
		Hibernate.initialize(s.getActors());
		Hibernate.initialize(s.getEpisodes());
		return s;
	}

	@Override
	public Movie findMovieById(int id) {
		Movie m =  movieDao.findById(id);
		Hibernate.initialize(m.getActors());
		return m;
	}

	@Override
	public Screenplay findById(int id) {
		return null;
	}

	@Override
	public Screenplay findByPersonId(int id) {
		
		return null;
	}
}
