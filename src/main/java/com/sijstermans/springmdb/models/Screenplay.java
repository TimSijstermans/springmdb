package com.sijstermans.springmdb.models;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="screenplay")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Screenplay {
	
	@Id
	@Column(name="screenplay_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int screenplayId;
	
	@Column(name = "name", nullable=false)
	private String name;
	
	@Column(name = "rating")
	private int rating;
	
	@Column(name = "description", nullable=false)
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "director_id", nullable=false)
	private Director director;
	
	@ManyToMany
	@Cascade({CascadeType.SAVE_UPDATE})
	@JoinTable(name = "SCREENPLAY_ACTORS", joinColumns = { @JoinColumn(name = "screenplay_id") }, inverseJoinColumns = { @JoinColumn(name = "person_id") })
	private List<Actor> actors = new ArrayList<Actor>();
	
	public Screenplay(){
		
	}
	public Screenplay(String name, int rating, String description, Director director) {
		this.name = name;
		this.rating = rating;
		this.description = description;
		this.director = director;
	}
	
	public int getScreenplayId() {
		return screenplayId;
	}
	public void setScreenplayId(int screenplayId) {
		this.screenplayId = screenplayId;
	}
	
	@NotNull
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}	
	
	@NotNull
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@NotNull
	public Director getDirector() {
		return director;
	}

	public void setDirector(Director director_id) {
		this.director = director_id;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}
	
	public void addActor(Actor actor) {
		this.actors.add(actor);
	}
	
	
}
