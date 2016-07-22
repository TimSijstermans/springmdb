package com.sijstermans.springmdb.dao;

import java.util.List;

import com.sijstermans.springmdb.models.Series;

public interface SeriesDao {
	List<Series> findAll();

	Series findById(int id);
}
