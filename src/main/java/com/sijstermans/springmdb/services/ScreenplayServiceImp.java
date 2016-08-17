package com.sijstermans.springmdb.services;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sijstermans.springmdb.dao.EpisodeDao;
import com.sijstermans.springmdb.dao.MovieDao;
import com.sijstermans.springmdb.dao.ScreenplayDao;
import com.sijstermans.springmdb.dao.SeriesDao;
import com.sijstermans.springmdb.models.Episode;
import com.sijstermans.springmdb.models.Movie;
import com.sijstermans.springmdb.models.Screenplay;
import com.sijstermans.springmdb.models.Series;

@Transactional
@Service
public class ScreenplayServiceImp implements ScreenplayService {

	@Autowired
	SeriesDao seriesDao;
	
	@Autowired
	EpisodeDao episodeDao;
	
	@Autowired
	MovieDao movieDao;
	
	@Autowired
	ScreenplayDao screenplayDao;
	
	@Override
	public void add(Screenplay sp) {
		screenplayDao.add(sp);
	}
	
	@Override
	public void addEpisode(Episode episode) {
		episodeDao.add(episode);
	}

	@Override
	public void deleteEpisode(int id) {
		episodeDao.delete(episodeDao.find(id));		
	}

	@Override
	public void deleteScreenplay(int id) {
		screenplayDao.delete(screenplayDao.find(id));		
	}

	@Override
	public List<Screenplay> findAll() {
		List<Screenplay> sp = screenplayDao.getAll();
		for (Screenplay entry : sp) {
			Hibernate.initialize(entry.getActors());
			if (entry.getClass().equals(Series.class)){
				Hibernate.initialize(((Series) entry).getEpisodes());
			}
		}
		return sp;
	}

	@Override
	public List<Movie> findAllMovies() {
		List<Movie> m = movieDao.getAll();
		for (Movie entry : m) {
			Hibernate.initialize(entry.getActors());
		}
		return m;
	}

	public List<Series> findAllSeries() {
		List<Series> s = seriesDao.getAll();
		for (Series entry : s) {
			Hibernate.initialize(entry.getEpisodes());
			Hibernate.initialize(entry.getActors());
		}
		return s;
	}

	@Override
	public Screenplay findById(int id) {
		Screenplay sp = screenplayDao.find(id);
		Hibernate.initialize(sp.getActors());
		if ( sp.getClass().equals(Series.class)){
			Hibernate.initialize(((Series) sp).getEpisodes());
		}
		return sp;
	}

	@Override
	public List<Screenplay> findByPersonId(int id) {
		List<Screenplay> sp = screenplayDao.findByPersonId(id);
		for (Screenplay entry : sp) {
			Hibernate.initialize(entry.getActors());
			if (entry.getClass().equals(Series.class)){
				Hibernate.initialize(((Series) entry).getEpisodes());
			}
		}
		return sp;
	}

	@Override
	public void update(Screenplay sp) {
		screenplayDao.update(sp);
	}
}
