package com.sijstermans.springmdb.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sijstermans.springmdb.models.Episode;
import com.sijstermans.springmdb.models.EpisodeContext;
import com.sijstermans.springmdb.models.Movie;
import com.sijstermans.springmdb.models.Screenplay;
import com.sijstermans.springmdb.models.Series;
import com.sijstermans.springmdb.services.ScreenplayService;

@RestController
@RequestMapping(value = "/screenplays")
public class ScreenplayController {
	@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Post data invalid")
	class InvalidInputException extends RuntimeException{
		public InvalidInputException(String message){		
			super(message);
		}
	}
	
	@Autowired
	private ScreenplayService screenplayService;
	

	/***************************************************************
	 *  														   *
	 * 							 SCREENPLAYS                       *
	 * 															   * 
	 ***************************************************************/
	
	//Get all
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Screenplay> getScreenplays() {
		return screenplayService.findAll();
	}

	/***************************************************************
	 * 															   *
	 * 								SERIES						   *
	 * 															   *
	 ***************************************************************/
	
	//Get all
	@RequestMapping(value = "/series", method = RequestMethod.GET)
	@ResponseBody
	public List<Series> getSeries() {
		return screenplayService.findAllSeries();
	}
	
	//Get one
	@RequestMapping(value = "/series/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Series getSeriesById(@PathVariable int id) {
		return (Series) screenplayService.findById(id);
	}
	
	//New Series
	@RequestMapping(value = "/series", method = RequestMethod.POST)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public Series postSeries(@Valid @RequestBody Series series, BindingResult bindingResult) {
		if(bindingResult.hasErrors()){
			throw new InvalidInputException("Series post data malformed: " + bindingResult.getFieldErrors());
		}
		screenplayService.add(series);
		return series;
	}
	
	//Delete Series
	@RequestMapping(value = "/series/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public void deleteSeries(@PathVariable int id) {
		screenplayService.deleteScreenplay(id);
	}
	
	//New Episode
	@RequestMapping(value = "/series/episode", method = RequestMethod.POST)
	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED)
	public Series postEpisode(@Valid @RequestBody EpisodeContext ctx, BindingResult bindingResult) {
		if(bindingResult.hasErrors()){
			throw new InvalidInputException("Episode post data malformed: " + bindingResult.getFieldErrors());
		}
		Episode episode = ctx.getEpisode();
	
		Series s = ctx.getSeries();
		episode.setSeries_id(s);

		screenplayService.addEpisode(episode);

		return s;
	}
	
	//Delete Episode
	@RequestMapping(value = "/series/episode/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public void deleteEpisode(@PathVariable int id) {
		screenplayService.deleteEpisode(id);
	}
	
	
	/***************************************************************
	 * 															   * 
	 * 								MOVIES						   *
	 * 															   * 
	 ***************************************************************/
	
	//Get all
	@RequestMapping(value = "/movies", method = RequestMethod.GET)
	@ResponseBody
	public List<Movie> getMovies() {
		return screenplayService.findAllMovies();
	}
	
	//Get one
	@RequestMapping(value = "/movies/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Movie getMovieById(@PathVariable int id) {
		return (Movie) screenplayService.findById(id);
	}	
	
	//New Movie
	@RequestMapping(value = "/movies", method = RequestMethod.POST)
	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED)
	public Movie postMovie(@Valid @RequestBody Movie movie, BindingResult bindingResult) {
		if(bindingResult.hasErrors()){
			throw new InvalidInputException("Movies post data malformed: " + bindingResult.getFieldErrors());
		}
		screenplayService.add(movie);
		return movie;
	}
	
	//Delete Movie
	@RequestMapping(value = "/movies/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public void deleteMovie(@PathVariable int id) {
		screenplayService.deleteScreenplay(id);
	}

}
