package com.sijstermans.springmdb.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "episode")
public class Episode {
	@Id
	@Column(name="episode_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int episode_id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="series_id")
	@JsonIgnore
	private Series series_id;
	
	public Episode(){
		
	}
	
	public Episode(String name, String description, Series series){
		this.description = description;
		this.name = name;
		this.series_id = series;
	}

	public int getEpisode_id() {
		return episode_id;
	}

	public void setEpisode_id(int episode_id) {
		this.episode_id = episode_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Series getSeries_id() {
		return series_id;
	}

	public void setSeries_id(Series series_id) {
		this.series_id = series_id;
	}
	
}
