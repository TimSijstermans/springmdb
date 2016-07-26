package com.sijstermans.springmdb.models;

public class EpisodeContext {
    private Episode episode;
    private Series series;
    
	public EpisodeContext() {
	}
	public EpisodeContext(Episode episode, Series series) {
		this.episode = episode;
		this.series = series;
	}
	
	public Episode getEpisode() {
		return episode;
	}
	public void setEpisode(Episode episode) {
		this.episode = episode;
	}
	public Series getSeries() {
		return series;
	}
	public void setSeries(Series series) {
		this.series = series;
	}
}
