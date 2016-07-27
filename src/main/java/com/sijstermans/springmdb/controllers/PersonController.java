package com.sijstermans.springmdb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sijstermans.springmdb.models.Director;
import com.sijstermans.springmdb.models.Person;
import com.sijstermans.springmdb.models.Screenplay;
import com.sijstermans.springmdb.services.PersonService;
import com.sijstermans.springmdb.services.ScreenplayService;


@Controller
@RequestMapping(value = "/persons")
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@Autowired
	private ScreenplayService screenplayService;
	
	/***************************************************************
	 *  														   *
	 * 							 PERSONS	                       *
	 * 															   * 
	 ***************************************************************/
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Person> getPersons() {
		return personService.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Person getPersonById(@PathVariable int id) {
		return personService.findById(id);
	}
	
	@RequestMapping(value = "/{id}/screenplays", method = RequestMethod.GET)
	@ResponseBody
	public List<Screenplay> getScreenplaysByPersonId(@PathVariable int id) {
		return screenplayService.findByPersonId(id);
	}	
	
	/***************************************************************
	 *  														   *
	 * 							 DIRECTOR	                       *
	 * 															   * 
	 ***************************************************************/
	
	@RequestMapping(value = "/directors", method = RequestMethod.GET)
	@ResponseBody
	public List<Director> getDirectors() {
		return personService.findAllDirectors();
	}

	@RequestMapping(value = "/directors/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Director getDirectorById(@PathVariable int id) {
		return personService.findDirectorById(id);
	}
	
}
