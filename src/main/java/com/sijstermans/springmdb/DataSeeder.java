package com.sijstermans.springmdb;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sijstermans.springmdb.models.Actor;
import com.sijstermans.springmdb.models.Director;
import com.sijstermans.springmdb.models.Episode;
import com.sijstermans.springmdb.models.Movie;
import com.sijstermans.springmdb.models.Series;

public class DataSeeder {
	@Autowired
	private SessionFactory sF;
	
	public void seedData(){

		Session session = sF.openSession();
		session.beginTransaction();
		
		Director dA = new Director("Henk", "De Vries", new Date(makeDate("11-05-1978")));
		Director dB = new Director("Johan", "Tillema", new Date(makeDate("01-09-1969")));
		Director dC = new Director("Steven", "Speelberg", new Date(makeDate("01-09-1942")));
		
		Actor aA = new Actor("Bart", "Pit", new Date(makeDate("25-02-1973")));
		Actor aB = new Actor("Nicolaas", "Kooi", new Date(makeDate("16-11-1965")));
		Actor aC = new Actor("Angelientje", "Jolig", new Date(makeDate("08-02-1973")));
		Actor aD = new Actor("David", "Hassemoff", new Date(makeDate("21-03-1981")));
		Actor aE = new Actor("Arjan", "Wastlink", new Date(makeDate("06-07-1989")));
		Actor aF = new Actor("Tom", "Reis", new Date(makeDate("03-07-1962")));
		
		Movie mA = new Movie("De Hongerspelen", 4, "Spannende film over wie het meeste eten kan verzamelen", dA, Time.valueOf("01:50:00"));
		mA.addActor(aA);
		mA.addActor(aC);
		Movie mB = new Movie("IJstijd 2", 3,  "Tijdloze animatiefilm over een stel beesten in de ijstijd", dC, Time.valueOf("02:10:00"));
		mB.addActor(aC);
		mB.addActor(aE);
		Movie mC = new Movie("Vlodder", 3, "Een Nederlandse komedie zonder humor", dA, Time.valueOf("01:45:00"));
		mC.addActor(aB);
		mC.addActor(aD);
		Movie mD = new Movie("Missie Onmogelijk", 5, "Spannende film waarin Ethan Jaag (Tom Reis) een gevaarlijk plan uit moet schakelen",  dC, Time.valueOf("02:30:00"));
		mD.addActor(aB);
		mD.addActor(aD);
		mD.addActor(aF);
		
		Series sA = new Series("Walking Dooien", dB, "Een adembenemende serie over het reilen en zeilen van Rick Ross en zijn crew");
		sA.setRating(4);
		sA.addActor(aA);
		sA.addActor(aC);
		sA.addActor(aE);
		
		Episode sAEA = new Episode("The beginning", "Dit is aflevering 1", sA);
		Episode sAEB = new Episode("The Second episode", "Dit is aflevering 2", sA);
		Episode sAEC = new Episode("The new beginning", "Dit is aflevering 3", sA);
		
		Series sB = new Series("Breaking Beds", dB, "Walter de Wit heeft slaap problemen");
		sB.setRating(5);
		sB.addActor(aB);
		sB.addActor(aF);
		
		Episode sBEA = new Episode("No Sleep", "Dit is aflevering 1", sB);
		Episode sBEB = new Episode("Still Awake", "Dit is aflevering 2", sB);
		Episode sBEC = new Episode("Out of Bed", "Dit is aflevering 3", sB);
		
		session.save(dA);
		session.save(dB);
		session.save(dC);
		
		session.save(aA);
		session.save(aB);
		session.save(aC);
		session.save(aD);
		session.save(aE);
		
		session.save(sA);
		session.save(sAEA);
		session.save(sAEB);
		session.save(sAEC);
		
		session.save(sB);
		session.save(sBEA);
		session.save(sBEB);
		session.save(sBEC);
		
		session.save(mA);
		session.save(mB);
		session.save(mC);
		session.save(mD);

		session.getTransaction().commit();
		session.close();
	}   
	
	private long makeDate(String s){
		SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date d = null;
		try {
			d = f.parse(s);
			return d.getTime();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public void setsF(SessionFactory sF) {
		this.sF = sF;
	}
}
