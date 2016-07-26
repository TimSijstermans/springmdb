package com.sijstermans.springmdb.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.sijstermans.springmdb.models.Episode;

@Repository
public class EpisodeDaoImp extends AbstractDao implements EpisodeDao {

	@Override
	public int addEpisode(Episode episode) {
		Session s = getSession();
		s.save(episode);
		
		return episode.getSeries_id().getScreenplayId();
	}

	@Override
	public void deleteEpisode(int id) {
		Session s = getSession();
		Episode toDel = s.get(Episode.class, id);
		s.delete(toDel);		
	}

}
