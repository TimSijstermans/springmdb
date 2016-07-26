package com.sijstermans.springmdb.models;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "actor")
@PrimaryKeyJoinColumn(name = "person_id")
public class Actor extends Person{
	
	@Transient
	String job = "Actor";
	
	@ManyToMany(mappedBy="actors")
	private List<Screenplay> screenplays;
	
	public Actor(){
		
	}
	public Actor(String name, String lastname, Date birthdate) {
		super(name, lastname, birthdate);
	}
	
	public String getJob() {
		return job;
	}
	
}
