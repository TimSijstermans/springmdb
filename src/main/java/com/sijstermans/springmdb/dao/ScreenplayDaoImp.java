package com.sijstermans.springmdb.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sijstermans.springmdb.models.Episode;
import com.sijstermans.springmdb.models.Screenplay;

@Repository
public class ScreenplayDaoImp extends AbstractDao<Screenplay, Integer> implements ScreenplayDao {
	
	@Override
	public List<Screenplay> findByPersonId(int personId) {
		Session s = getSession();
		Criteria crit = s.createCriteria(Screenplay.class)
				.createAlias("director", "directorAlias")
				.createAlias("actors", "actorAlias")
				.add(Restrictions.disjunction()
					.add(Restrictions.eq("directorAlias.personId", personId))
					.add(Restrictions.eq("actorAlias.personId", personId))
		).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);	
		return crit.list();
	}
}
