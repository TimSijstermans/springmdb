package com.sijstermans.springmdb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sijstermans.springmdb.models.Person;
import com.sijstermans.springmdb.models.Series;
import com.sijstermans.springmdb.services.PersonService;
import com.sijstermans.springmdb.services.ScreenplayService;


@Controller
@RequestMapping(value = "/persons")
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Person> getPersons() {
		return personService.findAll();
	}
	
}
