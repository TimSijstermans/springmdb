package com.sijstermans.springmdb.services;

import java.util.List;

import com.sijstermans.springmdb.models.Episode;
import com.sijstermans.springmdb.models.Movie;
import com.sijstermans.springmdb.models.Screenplay;
import com.sijstermans.springmdb.models.Series;

public interface ScreenplayService {
	public List<Series> findAllSeries();
	
	public List<Movie> findAllMovies();
	
	public List<Screenplay> findAll();
	
	public Series findSeriesById(int id);
	
	public Movie findMovieById(int id);
	
	public Screenplay findById(int id);
	
	public Screenplay findByPersonId(int id);

	public int addMovie(Movie m);

	public int addSeries(Series s);

	public List<Screenplay> findScreenplaysByPersonId(int personId);

	public int addEpisode(Episode episode);

	public void deleteEpisode(int id);

	public void deleteScreenplay(int id);
	
}
