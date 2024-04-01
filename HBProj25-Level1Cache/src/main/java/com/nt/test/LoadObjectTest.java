package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.nt.entity.Movie;
import com.nt.util.HibernateUtil;

public class LoadObjectTest {

	public static void main(String[] args) {
		SessionFactory factory=HibernateUtil.getSessionFactory();
//get Session object
		Session ses=HibernateUtil.getSession();
		try{
			
			//load object
			Movie movie=(Movie)ses.get(Movie.class,101);//Collects from DB AND keps L1 cache
			System.out.println(movie);
			System.out.println("--------------------------");
			Movie movie1=ses.get(Movie.class,101);//collects from L1 cache
			System.out.println(movie1);
			Movie movie2=ses.get(Movie.class, 1001);
			System.out.println(movie2);
			System.out.println("-------------------");
			Movie movie3=ses.get(Movie.class, 1001);
			System.out.println(movie3);
			Movie movie4=ses.get(Movie.class, 101);
			System.out.println(movie4);
			System.out.println("=========================");
			ses.evict(movie);
			Movie movie5=ses.get(Movie.class, 101);
			System.out.println(movie5);
			ses.clear();
			Movie movie6=ses.get(Movie.class,101);
			System.out.println(movie6);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
