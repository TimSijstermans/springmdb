package com.sijstermans.springmdb;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sijstermans.springmdb.models.Episode;
import com.sijstermans.springmdb.models.Series;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {
		System.out.println("Hello World! Starting...");

		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("/application-context.xml");

		DataSeeder ds = (DataSeeder) applicationContext.getBean("dataSeeder");

		ds.seedData();
		ds = null;
//		verifySeed((SessionFactory) applicationContext.getBean("sessionFactory"));

		System.out.println("Hello World! Done...");
	}

//	private static void verifySeed(SessionFactory sf) {
//		Session session = sf.openSession();
//		session.beginTransaction();
//		List<Series> list = session.createCriteria(Series.class).list();
//
//		for (Series s : list) {
//			List<Episode> eps = s.getEpisodes();
//			System.out.println("Series name: " + s.getName());
//			for (Episode ep : eps) {
//				System.out.println("\tEpisode name: " + ep.getName());
//				System.out.println("\tDirected by: " + ep.getDirector_id().getName() + " " + ep.getDirector_id().getLastname());
//				System.out.println("\tDescription: " + ep.getDescription());
//				System.out.println("");
//			}
//			System.out.println("");
//		}
//		session.close();
//	}

}
