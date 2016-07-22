package com.sijstermans.springmdb.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "director")
@PrimaryKeyJoinColumn(name = "person_id")
public class Director extends Person{
	
	@Transient
	String job = "Director";
	
	public Director(){
		
	}
	public Director(String name, String lastname, Date birthdate) {
		super(name, lastname, birthdate);
	}
	
	public String getJob() {
		return job;
	}
}
