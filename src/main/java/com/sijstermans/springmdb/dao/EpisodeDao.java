package com.sijstermans.springmdb.dao;

import com.sijstermans.springmdb.models.Episode;

public interface EpisodeDao {
	int addEpisode(Episode episode);

	void deleteEpisode(int id);
}
