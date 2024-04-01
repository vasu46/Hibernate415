package com.nit.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nit.entity.Movie;
import com.nit.util.HibernateUtil;

public class LoadObjectTest {

	public static void main(String[] args) {
		//getSessionFactory obj
		SessionFactory factory=HibernateUtil.getSessionFactory();
		//get session obj
		Session ses=HibernateUtil.getSession();
		
	try{
	  Movie movie=ses.get(Movie.class, 1001);
	  System.out.println(movie);
		  
		}//try
		catch(Exception e) {
			
			e.printStackTrace();
			}
		}
				

	}


