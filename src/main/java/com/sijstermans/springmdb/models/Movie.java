package com.sijstermans.springmdb.models;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "movie")
@PrimaryKeyJoinColumn(name = "screenplay_id")
public class Movie extends Screenplay {

	@Column(name = "length")
	private Time length;
		
	@Transient
	private String type = "Movie";
	
	public Movie(){
		
	}
	public Movie(String name, int rating, String description, Director director, Time length){
		super(name, rating, description, director);
		this.length = length;	
	}

	public Time getLength() {
		return length;
	}

	public void setLength(Time length) {
		this.length = length;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
}
