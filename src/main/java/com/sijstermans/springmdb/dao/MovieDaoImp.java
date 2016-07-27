package com.sijstermans.springmdb.dao;

import org.springframework.stereotype.Repository;

import com.sijstermans.springmdb.models.Movie;

@Repository
public class MovieDaoImp extends AbstractDao<Movie, Integer> implements MovieDao {

}
