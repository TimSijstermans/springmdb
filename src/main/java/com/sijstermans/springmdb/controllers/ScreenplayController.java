package com.sijstermans.springmdb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sijstermans.springmdb.models.Movie;
import com.sijstermans.springmdb.models.Screenplay;
import com.sijstermans.springmdb.models.Series;
import com.sijstermans.springmdb.services.ScreenplayService;

@RestController
@RequestMapping(value = "/screenplays")
public class ScreenplayController {
	@Autowired
	private ScreenplayService screenplayService;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Screenplay> getScreenplays() {
		return screenplayService.findAll();
	}
	
	@RequestMapping(value = "/series", method = RequestMethod.GET)
	@ResponseBody
	public List<Series> getSeries() {
		return screenplayService.findAllSeries();
	}
	
	@RequestMapping(value = "/series/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Series getSeriesById(@PathVariable int id) {
		return screenplayService.findSeriesById(id);
	}
	
	@RequestMapping(value = "/series", method = RequestMethod.POST)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public int postSeries(@RequestBody Series series) {
		return screenplayService.addSeries(series);
	}
	
	@RequestMapping(value = "/movies", method = RequestMethod.GET)
	@ResponseBody
	public List<Movie> getMovies() {
		return screenplayService.findAllMovies();
	}
	
	@RequestMapping(value = "/movies", method = RequestMethod.POST)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public int postMovie(@RequestBody Movie movie) {
		return screenplayService.addMovie(movie);
	}
	
	@RequestMapping(value = "/movies/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Movie getMovieById(@PathVariable int id) {
		return screenplayService.findMovieById(id);
	}

}
