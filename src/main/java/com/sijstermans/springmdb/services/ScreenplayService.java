package com.sijstermans.springmdb.services;

import java.util.List;

import com.sijstermans.springmdb.models.Episode;
import com.sijstermans.springmdb.models.Movie;
import com.sijstermans.springmdb.models.Screenplay;
import com.sijstermans.springmdb.models.Series;

public interface ScreenplayService {
	public void addEpisode(Episode episode);
	
	public void add(Screenplay sp);
		
	public void deleteEpisode(int id);
	
	public void deleteScreenplay(int id);
	
	public List<Screenplay> findAll();
	
	public List<Movie> findAllMovies();

	public List<Series> findAllSeries();

	public Screenplay findById(int id);

	public List<Screenplay> findByPersonId(int id);	
}
