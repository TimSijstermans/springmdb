package com.sijstermans.springmdb.dao;

import org.springframework.stereotype.Repository;

import com.sijstermans.springmdb.models.Episode;

@Repository
public class EpisodeDaoImp extends AbstractDao<Episode, Integer> implements EpisodeDao {
}
