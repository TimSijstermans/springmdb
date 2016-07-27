package com.sijstermans.springmdb.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.sijstermans.springmdb.models.Series;

@Repository
public class SeriesDaoImp extends AbstractDao<Series, Integer> implements SeriesDao {
}
